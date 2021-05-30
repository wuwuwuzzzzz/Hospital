<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="名　　称" prop="name">
        <el-input v-model="queryParams.name" placeholder="请输入名称" clearable size="small" style="width: 240px" @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="购入时间" prop="startTime">
        <el-date-picker clearable size="small" v-model="queryParams.startTime" type="date" style="width: 240px" value-format="yyyy-MM-dd" placeholder="选择购入时间"></el-date-picker>
      </el-form-item>
      <el-form-item label="修改时间" prop="updateTime">
        <el-date-picker clearable size="small" v-model="queryParams.updateTime" type="date" style="width: 240px" value-format="yyyy-MM-dd" placeholder="选择修改时间"></el-date-picker>
      </el-form-item>
      <el-form-item label="供应商名" prop="supplierName">
        <el-select v-model="queryParams.supplierName" placeholder="请选择" filterable clearable size="small" style="width: 240px">
          <el-option v-for="item in sysSupplierOptions" :key="item.supplierId" :label="item.supplierName" :value="item.supplierName" />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAdd" v-hasPermi="['system:drug:add']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="success" icon="el-icon-edit" size="mini" :disabled="single" @click="handleUpdate" v-hasPermi="['system:drug:edit']">修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="danger" icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleDelete" v-hasPermi="['system:drug:remove']">删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" icon="el-icon-download" size="mini" @click="handleExport" v-hasPermi="['system:drug:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="drugList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
<!--      <el-table-column label="编号" align="center" prop="id" />-->
      <el-table-column label="名称" align="center" prop="name" show-overflow-tooltip />
      <el-table-column label="保质期" align="center" prop="life">
        <template slot-scope="scope">
          <span>{{scope.row.life}}天</span>
        </template>
      </el-table-column>
      <el-table-column label="购入时间" align="center" prop="startTime" width="180">
        <template slot-scope="scope">
          <span v-if="scope.row.startTime == null">-</span>
          <span v-else>{{ scope.row.startTime }}</span>
        </template>
      </el-table-column>
      <el-table-column label="修改人" align="center" prop="userName">
        <template slot-scope="scope">
          <span v-if="scope.row.userName == null">-</span>
          <span v-else>{{ scope.row.userName }}</span>
        </template>
      </el-table-column>
      <el-table-column label="修改时间" align="center" prop="updateTime" width="180">
        <template slot-scope="scope">
          <span v-if="scope.row.updateTime == null">-</span>
          <span v-else>{{ scope.row.updateTime }}</span>
        </template>
      </el-table-column>
      <el-table-column label="数量" align="center" prop="number" />
      <el-table-column label="供应商" align="center" prop="supplierName" width="210" show-overflow-tooltip/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:drug:edit']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)" v-hasPermi="['system:drug:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize" @pagination="getList"/>

    <!-- 添加或修改药品信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入名称" />
        </el-form-item>
        <el-form-item label="保质期" prop="life">
          <el-input v-model="form.life" placeholder="请输入药品保质期" />
        </el-form-item>
        <el-form-item label="购入时间" prop="startTime">
          <el-date-picker clearable size="small" v-model="form.startTime" type="datetime" value-format="yyyy-MM-dd HH:mm:ss" placeholder="选择购入时间" style="width: 380px"></el-date-picker>
        </el-form-item>
        <el-form-item label="供应商" prop="supplierName">
          <el-select v-model="form.supplierName" placeholder="请选择" filterable clearable size="small" style="width: 380px">
            <el-option v-for="item in sysSupplierOptions" :key="item.supplierId" :label="item.supplierName" :value="item.supplierName" />
          </el-select>
        </el-form-item>
        <el-form-item label="数量" prop="number">
          <el-input v-model="form.number" placeholder="请输入数量" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listDrug, getDrug, delDrug, addDrug, updateDrug, exportDrug } from "@/api/system/drug";
import { sysSupplierList } from "@/api/system/supplier";

export default {
  name: "Drug",
  components: {
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 药品信息表格数据
      drugList: [],
      // 弹出层标题
      title: "",
      // 供应商
      sysSupplierOptions: [],
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        life: null,
        startTime: null,
        updateBy: null,
        updateTime: null,
        number: null,
        supplierName: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getSysDeptOptions();
    this.getList();
  },
  methods: {
    /** 查询药品信息列表 */
    getList() {
      this.loading = true;
      listDrug(this.queryParams).then(response => {
        this.drugList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        name: null,
        life: null,
        startTime: null,
        updateBy: null,
        updateTime: null,
        supplierId: null,
        number: null,
        supplierName: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加药品信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getDrug(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改药品信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateDrug(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDrug(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除药品信息编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delDrug(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有药品信息数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportDrug(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    },
    getSysDeptOptions(){
      sysSupplierList().then(res => {
        console.log(res);
        this.sysSupplierOptions = res.data;
      });
    },
  }
};
</script>
