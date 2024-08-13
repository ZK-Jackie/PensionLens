<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="区域名称" prop="areaName">
        <el-input
          v-model="queryParams.areaName"
          placeholder="请输入区域名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="计算视同缴费年限的截止年份" prop="baseYear">
        <el-input
          v-model="queryParams.baseYear"
          placeholder="请输入计算视同缴费年限的截止年份"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="该统筹区域按照【国发[1997]26号】要求实施相应政策的年份" prop="policy1999">
        <el-input
          v-model="queryParams.policy1999"
          placeholder="请输入该统筹区域按照【国发[1997]26号】要求实施相应政策的年份"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="该统筹区域按照【国发[2005]38号】要求实施相应政策的年份" prop="policy2005">
        <el-input
          v-model="queryParams.policy2005"
          placeholder="请输入该统筹区域按照【国发[2005]38号】要求实施相应政策的年份"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:area_code_dict:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:area_code_dict:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:area_code_dict:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:area_code_dict:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="area_code_dictList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="区域代码" align="center" prop="code" />
      <el-table-column label="区域名称" align="center" prop="areaName" />
      <el-table-column label="计算视同缴费年限的截止年份" align="center" prop="baseYear" />
      <el-table-column label="该统筹区域按照【国发[1997]26号】要求实施相应政策的年份" align="center" prop="policy1999" />
      <el-table-column label="该统筹区域按照【国发[2005]38号】要求实施相应政策的年份" align="center" prop="policy2005" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:area_code_dict:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:area_code_dict:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改测算统筹区域对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="区域名称" prop="areaName">
          <el-input v-model="form.areaName" placeholder="请输入区域名称" />
        </el-form-item>
        <el-form-item label="计算视同缴费年限的截止年份" prop="baseYear">
          <el-input v-model="form.baseYear" placeholder="请输入计算视同缴费年限的截止年份" />
        </el-form-item>
        <el-form-item label="该统筹区域按照【国发[1997]26号】要求实施相应政策的年份" prop="policy1999">
          <el-input v-model="form.policy1999" placeholder="请输入该统筹区域按照【国发[1997]26号】要求实施相应政策的年份" />
        </el-form-item>
        <el-form-item label="该统筹区域按照【国发[2005]38号】要求实施相应政策的年份" prop="policy2005">
          <el-input v-model="form.policy2005" placeholder="请输入该统筹区域按照【国发[2005]38号】要求实施相应政策的年份" />
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
import { listArea_code_dict, getArea_code_dict, delArea_code_dict, addArea_code_dict, updateArea_code_dict } from "@/api/system/area_code_dict";

export default {
  name: "Area_code_dict",
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
      // 测算统筹区域表格数据
      area_code_dictList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        areaName: null,
        baseYear: null,
        policy1999: null,
        policy2005: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        areaName: [
          { required: true, message: "区域名称不能为空", trigger: "blur" }
        ],
        baseYear: [
          { required: true, message: "计算视同缴费年限的截止年份不能为空", trigger: "blur" }
        ],
        policy1999: [
          { required: true, message: "该统筹区域按照【国发[1997]26号】要求实施相应政策的年份不能为空", trigger: "blur" }
        ],
        policy2005: [
          { required: true, message: "该统筹区域按照【国发[2005]38号】要求实施相应政策的年份不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询测算统筹区域列表 */
    getList() {
      this.loading = true;
      listArea_code_dict(this.queryParams).then(response => {
        this.area_code_dictList = response.rows;
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
        code: null,
        areaName: null,
        baseYear: null,
        policy1999: null,
        policy2005: null
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
      this.ids = selection.map(item => item.code)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加测算统筹区域";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const code = row.code || this.ids
      getArea_code_dict(code).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改测算统筹区域";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.code != null) {
            updateArea_code_dict(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addArea_code_dict(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const codes = row.code || this.ids;
      this.$modal.confirm('是否确认删除测算统筹区域编号为"' + codes + '"的数据项？').then(function() {
        return delArea_code_dict(codes);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/area_code_dict/export', {
        ...this.queryParams
      }, `area_code_dict_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
