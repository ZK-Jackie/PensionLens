<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="男性人数-起始人口" prop="male">
        <el-input
          v-model="queryParams.male"
          placeholder="请输入男性人数-起始人口"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="女性人数-起始人口" prop="female">
        <el-input
          v-model="queryParams.female"
          placeholder="请输入女性人数-起始人口"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="男性死亡模式" prop="maleDeathMode">
        <el-input
          v-model="queryParams.maleDeathMode"
          placeholder="请输入男性死亡模式"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="女性死亡模式" prop="femaleDeathMode">
        <el-input
          v-model="queryParams.femaleDeathMode"
          placeholder="请输入女性死亡模式"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="生育模式，对应BIRTH_MODE字典" prop="birthMode">
        <el-input
          v-model="queryParams.birthMode"
          placeholder="请输入生育模式，对应BIRTH_MODE字典"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="男性迁移模式" prop="maleMigrationMode">
        <el-input
          v-model="queryParams.maleMigrationMode"
          placeholder="请输入男性迁移模式"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="女性迁移模式" prop="femaleMigrationMode">
        <el-input
          v-model="queryParams.femaleMigrationMode"
          placeholder="请输入女性迁移模式"
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
          v-hasPermi="['system:person_predict_age:add']"
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
          v-hasPermi="['system:person_predict_age:edit']"
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
          v-hasPermi="['system:person_predict_age:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:person_predict_age:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="person_predict_ageList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="统筹区域，对应t_yctxcs_area_code_dict的code值" align="center" prop="planArea" />
      <el-table-column label="年龄" align="center" prop="age" />
      <el-table-column label="男性人数-起始人口" align="center" prop="male" />
      <el-table-column label="女性人数-起始人口" align="center" prop="female" />
      <el-table-column label="男性死亡模式" align="center" prop="maleDeathMode" />
      <el-table-column label="女性死亡模式" align="center" prop="femaleDeathMode" />
      <el-table-column label="生育模式，对应BIRTH_MODE字典" align="center" prop="birthMode" />
      <el-table-column label="男性迁移模式" align="center" prop="maleMigrationMode" />
      <el-table-column label="女性迁移模式" align="center" prop="femaleMigrationMode" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:person_predict_age:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:person_predict_age:remove']"
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

    <!-- 添加或修改人口预测参数（按年龄）对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="男性人数-起始人口" prop="male">
          <el-input v-model="form.male" placeholder="请输入男性人数-起始人口" />
        </el-form-item>
        <el-form-item label="女性人数-起始人口" prop="female">
          <el-input v-model="form.female" placeholder="请输入女性人数-起始人口" />
        </el-form-item>
        <el-form-item label="男性死亡模式" prop="maleDeathMode">
          <el-input v-model="form.maleDeathMode" placeholder="请输入男性死亡模式" />
        </el-form-item>
        <el-form-item label="女性死亡模式" prop="femaleDeathMode">
          <el-input v-model="form.femaleDeathMode" placeholder="请输入女性死亡模式" />
        </el-form-item>
        <el-form-item label="生育模式，对应BIRTH_MODE字典" prop="birthMode">
          <el-input v-model="form.birthMode" placeholder="请输入生育模式，对应BIRTH_MODE字典" />
        </el-form-item>
        <el-form-item label="男性迁移模式" prop="maleMigrationMode">
          <el-input v-model="form.maleMigrationMode" placeholder="请输入男性迁移模式" />
        </el-form-item>
        <el-form-item label="女性迁移模式" prop="femaleMigrationMode">
          <el-input v-model="form.femaleMigrationMode" placeholder="请输入女性迁移模式" />
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
import { listPerson_predict_age, getPerson_predict_age, delPerson_predict_age, addPerson_predict_age, updatePerson_predict_age } from "@/api/system/person_predict_age";

export default {
  name: "Person_predict_age",
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
      // 人口预测参数（按年龄）表格数据
      person_predict_ageList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        male: null,
        female: null,
        maleDeathMode: null,
        femaleDeathMode: null,
        birthMode: null,
        maleMigrationMode: null,
        femaleMigrationMode: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        male: [
          { required: true, message: "男性人数-起始人口不能为空", trigger: "blur" }
        ],
        female: [
          { required: true, message: "女性人数-起始人口不能为空", trigger: "blur" }
        ],
        maleDeathMode: [
          { required: true, message: "男性死亡模式不能为空", trigger: "blur" }
        ],
        femaleDeathMode: [
          { required: true, message: "女性死亡模式不能为空", trigger: "blur" }
        ],
        birthMode: [
          { required: true, message: "生育模式，对应BIRTH_MODE字典不能为空", trigger: "blur" }
        ],
        maleMigrationMode: [
          { required: true, message: "男性迁移模式不能为空", trigger: "blur" }
        ],
        femaleMigrationMode: [
          { required: true, message: "女性迁移模式不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询人口预测参数（按年龄）列表 */
    getList() {
      this.loading = true;
      listPerson_predict_age(this.queryParams).then(response => {
        this.person_predict_ageList = response.rows;
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
        male: null,
        female: null,
        maleDeathMode: null,
        femaleDeathMode: null,
        birthMode: null,
        maleMigrationMode: null,
        femaleMigrationMode: null
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
      this.title = "添加人口预测参数（按年龄）";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const planArea = row.planArea || this.ids
      getPerson_predict_age(planArea).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改人口预测参数（按年龄）";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.planArea != null) {
            updatePerson_predict_age(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPerson_predict_age(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除人口预测参数（按年龄）编号为"' + planAreas + '"的数据项？').then(function() {
        return delPerson_predict_age(planAreas);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/person_predict_age/export', {
        ...this.queryParams
      }, `person_predict_age_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
