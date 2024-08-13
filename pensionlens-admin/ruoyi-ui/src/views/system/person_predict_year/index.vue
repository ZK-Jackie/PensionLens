<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="男性预期寿命-死亡水平" prop="malePreLife">
        <el-input
          v-model="queryParams.malePreLife"
          placeholder="请输入男性预期寿命-死亡水平"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="女性预期寿命-死亡水平" prop="femalePreLife">
        <el-input
          v-model="queryParams.femalePreLife"
          placeholder="请输入女性预期寿命-死亡水平"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="出生性别比" prop="sexRatioBirth">
        <el-input
          v-model="queryParams.sexRatioBirth"
          placeholder="请输入出生性别比"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="男性迁移水平" prop="maleMigrationNumber">
        <el-input
          v-model="queryParams.maleMigrationNumber"
          placeholder="请输入男性迁移水平"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="女性迁移水平" prop="femaleMigrationNumber">
        <el-input
          v-model="queryParams.femaleMigrationNumber"
          placeholder="请输入女性迁移水平"
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
          v-hasPermi="['system:person_predict_year:add']"
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
          v-hasPermi="['system:person_predict_year:edit']"
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
          v-hasPermi="['system:person_predict_year:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:person_predict_year:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="person_predict_yearList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="统筹区域，对应t_yctxcs_area_code_dict的code值" align="center" prop="planArea" />
      <el-table-column label="年份" align="center" prop="year" />
      <el-table-column label="男性预期寿命-死亡水平" align="center" prop="malePreLife" />
      <el-table-column label="女性预期寿命-死亡水平" align="center" prop="femalePreLife" />
      <el-table-column label="出生性别比" align="center" prop="sexRatioBirth" />
      <el-table-column label="男性迁移水平" align="center" prop="maleMigrationNumber" />
      <el-table-column label="女性迁移水平" align="center" prop="femaleMigrationNumber" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:person_predict_year:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:person_predict_year:remove']"
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

    <!-- 添加或修改人口预测参数（按年份）对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="男性预期寿命-死亡水平" prop="malePreLife">
          <el-input v-model="form.malePreLife" placeholder="请输入男性预期寿命-死亡水平" />
        </el-form-item>
        <el-form-item label="女性预期寿命-死亡水平" prop="femalePreLife">
          <el-input v-model="form.femalePreLife" placeholder="请输入女性预期寿命-死亡水平" />
        </el-form-item>
        <el-form-item label="出生性别比" prop="sexRatioBirth">
          <el-input v-model="form.sexRatioBirth" placeholder="请输入出生性别比" />
        </el-form-item>
        <el-form-item label="男性迁移水平" prop="maleMigrationNumber">
          <el-input v-model="form.maleMigrationNumber" placeholder="请输入男性迁移水平" />
        </el-form-item>
        <el-form-item label="女性迁移水平" prop="femaleMigrationNumber">
          <el-input v-model="form.femaleMigrationNumber" placeholder="请输入女性迁移水平" />
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
import { listPerson_predict_year, getPerson_predict_year, delPerson_predict_year, addPerson_predict_year, updatePerson_predict_year } from "@/api/system/person_predict_year";

export default {
  name: "Person_predict_year",
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
      // 人口预测参数（按年份）表格数据
      person_predict_yearList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        malePreLife: null,
        femalePreLife: null,
        sexRatioBirth: null,
        maleMigrationNumber: null,
        femaleMigrationNumber: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        malePreLife: [
          { required: true, message: "男性预期寿命-死亡水平不能为空", trigger: "blur" }
        ],
        femalePreLife: [
          { required: true, message: "女性预期寿命-死亡水平不能为空", trigger: "blur" }
        ],
        sexRatioBirth: [
          { required: true, message: "出生性别比不能为空", trigger: "blur" }
        ],
        maleMigrationNumber: [
          { required: true, message: "男性迁移水平不能为空", trigger: "blur" }
        ],
        femaleMigrationNumber: [
          { required: true, message: "女性迁移水平不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询人口预测参数（按年份）列表 */
    getList() {
      this.loading = true;
      listPerson_predict_year(this.queryParams).then(response => {
        this.person_predict_yearList = response.rows;
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
        year: null,
        malePreLife: null,
        femalePreLife: null,
        sexRatioBirth: null,
        maleMigrationNumber: null,
        femaleMigrationNumber: null
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
      this.title = "添加人口预测参数（按年份）";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const planArea = row.planArea || this.ids
      getPerson_predict_year(planArea).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改人口预测参数（按年份）";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.planArea != null) {
            updatePerson_predict_year(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPerson_predict_year(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除人口预测参数（按年份）编号为"' + planAreas + '"的数据项？').then(function() {
        return delPerson_predict_year(planAreas);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/person_predict_year/export', {
        ...this.queryParams
      }, `person_predict_year_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
