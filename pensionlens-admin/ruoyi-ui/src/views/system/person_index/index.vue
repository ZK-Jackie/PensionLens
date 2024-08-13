<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="男性死亡率" prop="mDeathRate">
        <el-input
          v-model="queryParams.mDeathRate"
          placeholder="请输入男性死亡率"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="女性死亡率" prop="fDeathRate">
        <el-input
          v-model="queryParams.fDeathRate"
          placeholder="请输入女性死亡率"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="男性就业率" prop="mEmploymentRate">
        <el-input
          v-model="queryParams.mEmploymentRate"
          placeholder="请输入男性就业率"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="女性就业率" prop="fEmploymentRate">
        <el-input
          v-model="queryParams.fEmploymentRate"
          placeholder="请输入女性就业率"
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
          v-hasPermi="['system:person_index:add']"
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
          v-hasPermi="['system:person_index:edit']"
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
          v-hasPermi="['system:person_index:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:person_index:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="person_indexList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="统筹区域，对应t_yctxcs_area_code_dict的code值" align="center" prop="planArea" />
      <el-table-column label="年龄" align="center" prop="age" />
      <el-table-column label="男性死亡率" align="center" prop="mDeathRate" />
      <el-table-column label="女性死亡率" align="center" prop="fDeathRate" />
      <el-table-column label="男性就业率" align="center" prop="mEmploymentRate" />
      <el-table-column label="女性就业率" align="center" prop="fEmploymentRate" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:person_index:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:person_index:remove']"
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

    <!-- 添加或修改测算默认人口数量表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="男性死亡率" prop="mDeathRate">
          <el-input v-model="form.mDeathRate" placeholder="请输入男性死亡率" />
        </el-form-item>
        <el-form-item label="女性死亡率" prop="fDeathRate">
          <el-input v-model="form.fDeathRate" placeholder="请输入女性死亡率" />
        </el-form-item>
        <el-form-item label="男性就业率" prop="mEmploymentRate">
          <el-input v-model="form.mEmploymentRate" placeholder="请输入男性就业率" />
        </el-form-item>
        <el-form-item label="女性就业率" prop="fEmploymentRate">
          <el-input v-model="form.fEmploymentRate" placeholder="请输入女性就业率" />
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
import { listPerson_index, getPerson_index, delPerson_index, addPerson_index, updatePerson_index } from "@/api/system/person_index";

export default {
  name: "Person_index",
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
      // 测算默认人口数量表表格数据
      person_indexList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        mDeathRate: null,
        fDeathRate: null,
        mEmploymentRate: null,
        fEmploymentRate: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        mDeathRate: [
          { required: true, message: "男性死亡率不能为空", trigger: "blur" }
        ],
        fDeathRate: [
          { required: true, message: "女性死亡率不能为空", trigger: "blur" }
        ],
        mEmploymentRate: [
          { required: true, message: "男性就业率不能为空", trigger: "blur" }
        ],
        fEmploymentRate: [
          { required: true, message: "女性就业率不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询测算默认人口数量表列表 */
    getList() {
      this.loading = true;
      listPerson_index(this.queryParams).then(response => {
        this.person_indexList = response.rows;
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
        planArea: null,
        age: null,
        mDeathRate: null,
        fDeathRate: null,
        mEmploymentRate: null,
        fEmploymentRate: null
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
      this.ids = selection.map(item => item.planArea)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加测算默认人口数量表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const planArea = row.planArea || this.ids
      getPerson_index(planArea).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改测算默认人口数量表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.planArea != null) {
            updatePerson_index(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPerson_index(this.form).then(response => {
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
      const planAreas = row.planArea || this.ids;
      this.$modal.confirm('是否确认删除测算默认人口数量表编号为"' + planAreas + '"的数据项？').then(function() {
        return delPerson_index(planAreas);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/person_index/export', {
        ...this.queryParams
      }, `person_index_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
