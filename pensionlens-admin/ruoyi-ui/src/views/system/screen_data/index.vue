<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="数据名称列表，需要序列化和反序列化" prop="dataName">
        <el-input
          v-model="queryParams.dataName"
          placeholder="请输入数据名称列表，需要序列化和反序列化"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="数据所在表" prop="dataLocation">
        <el-input
          v-model="queryParams.dataLocation"
          placeholder="请输入数据所在表"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="数据键的标签名" prop="keyLabel">
        <el-input
          v-model="queryParams.keyLabel"
          placeholder="请输入数据键的标签名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="数据键的单位" prop="keyUnit">
        <el-input
          v-model="queryParams.keyUnit"
          placeholder="请输入数据键的单位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="数据值的标签名" prop="valueLabel">
        <el-input
          v-model="queryParams.valueLabel"
          placeholder="请输入数据值的标签名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="数据值的单位" prop="valueUnit">
        <el-input
          v-model="queryParams.valueUnit"
          placeholder="请输入数据值的单位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="数据呈现精度" prop="numPrecision">
        <el-input
          v-model="queryParams.numPrecision"
          placeholder="请输入数据呈现精度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="数据值最大值" prop="maxValue">
        <el-input
          v-model="queryParams.maxValue"
          placeholder="请输入数据值最大值"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="数据值最小值" prop="minValue">
        <el-input
          v-model="queryParams.minValue"
          placeholder="请输入数据值最小值"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="数据颜色id" prop="dataColorId">
        <el-input
          v-model="queryParams.dataColorId"
          placeholder="请输入数据颜色id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最后更新人id" prop="lastUpdateUserId">
        <el-input
          v-model="queryParams.lastUpdateUserId"
          placeholder="请输入最后更新人id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最后更新时间" prop="lastUpdateTime">
        <el-date-picker clearable
          v-model="queryParams.lastUpdateTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择最后更新时间">
        </el-date-picker>
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
          v-hasPermi="['system:screen_data:add']"
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
          v-hasPermi="['system:screen_data:edit']"
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
          v-hasPermi="['system:screen_data:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:screen_data:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="screen_dataList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="数据id" align="center" prop="dataId" />
      <el-table-column label="数据名称列表，需要序列化和反序列化" align="center" prop="dataName" />
      <el-table-column label="数据所在表" align="center" prop="dataLocation" />
      <el-table-column label="数据键的标签名" align="center" prop="keyLabel" />
      <el-table-column label="数据键的单位" align="center" prop="keyUnit" />
      <el-table-column label="数据值的标签名" align="center" prop="valueLabel" />
      <el-table-column label="数据值的单位" align="center" prop="valueUnit" />
      <el-table-column label="数据呈现精度" align="center" prop="numPrecision" />
      <el-table-column label="数据值最大值" align="center" prop="maxValue" />
      <el-table-column label="数据值最小值" align="center" prop="minValue" />
      <el-table-column label="数据颜色id" align="center" prop="dataColorId" />
      <el-table-column label="最后更新人id" align="center" prop="lastUpdateUserId" />
      <el-table-column label="最后更新时间" align="center" prop="lastUpdateTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.lastUpdateTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:screen_data:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:screen_data:remove']"
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

    <!-- 添加或修改大屏数据定位对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="数据名称列表，需要序列化和反序列化" prop="dataName">
          <el-input v-model="form.dataName" placeholder="请输入数据名称列表，需要序列化和反序列化" />
        </el-form-item>
        <el-form-item label="数据所在表" prop="dataLocation">
          <el-input v-model="form.dataLocation" placeholder="请输入数据所在表" />
        </el-form-item>
        <el-form-item label="数据键的标签名" prop="keyLabel">
          <el-input v-model="form.keyLabel" placeholder="请输入数据键的标签名" />
        </el-form-item>
        <el-form-item label="数据键的单位" prop="keyUnit">
          <el-input v-model="form.keyUnit" placeholder="请输入数据键的单位" />
        </el-form-item>
        <el-form-item label="数据值的标签名" prop="valueLabel">
          <el-input v-model="form.valueLabel" placeholder="请输入数据值的标签名" />
        </el-form-item>
        <el-form-item label="数据值的单位" prop="valueUnit">
          <el-input v-model="form.valueUnit" placeholder="请输入数据值的单位" />
        </el-form-item>
        <el-form-item label="数据呈现精度" prop="numPrecision">
          <el-input v-model="form.numPrecision" placeholder="请输入数据呈现精度" />
        </el-form-item>
        <el-form-item label="数据值最大值" prop="maxValue">
          <el-input v-model="form.maxValue" placeholder="请输入数据值最大值" />
        </el-form-item>
        <el-form-item label="数据值最小值" prop="minValue">
          <el-input v-model="form.minValue" placeholder="请输入数据值最小值" />
        </el-form-item>
        <el-form-item label="数据颜色id" prop="dataColorId">
          <el-input v-model="form.dataColorId" placeholder="请输入数据颜色id" />
        </el-form-item>
        <el-form-item label="最后更新人id" prop="lastUpdateUserId">
          <el-input v-model="form.lastUpdateUserId" placeholder="请输入最后更新人id" />
        </el-form-item>
        <el-form-item label="最后更新时间" prop="lastUpdateTime">
          <el-date-picker clearable
            v-model="form.lastUpdateTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择最后更新时间">
          </el-date-picker>
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
import { listScreen_data, getScreen_data, delScreen_data, addScreen_data, updateScreen_data } from "@/api/system/screen_data";

export default {
  name: "Screen_data",
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
      // 大屏数据定位表格数据
      screen_dataList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        dataName: null,
        dataLocation: null,
        keyLabel: null,
        keyUnit: null,
        valueLabel: null,
        valueUnit: null,
        numPrecision: null,
        maxValue: null,
        minValue: null,
        dataColorId: null,
        lastUpdateUserId: null,
        lastUpdateTime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        dataName: [
          { required: true, message: "数据名称列表，需要序列化和反序列化不能为空", trigger: "blur" }
        ],
        dataLocation: [
          { required: true, message: "数据所在表不能为空", trigger: "blur" }
        ],
        keyLabel: [
          { required: true, message: "数据键的标签名不能为空", trigger: "blur" }
        ],
        keyUnit: [
          { required: true, message: "数据键的单位不能为空", trigger: "blur" }
        ],
        valueLabel: [
          { required: true, message: "数据值的标签名不能为空", trigger: "blur" }
        ],
        valueUnit: [
          { required: true, message: "数据值的单位不能为空", trigger: "blur" }
        ],
        numPrecision: [
          { required: true, message: "数据呈现精度不能为空", trigger: "blur" }
        ],
        maxValue: [
          { required: true, message: "数据值最大值不能为空", trigger: "blur" }
        ],
        minValue: [
          { required: true, message: "数据值最小值不能为空", trigger: "blur" }
        ],
        dataColorId: [
          { required: true, message: "数据颜色id不能为空", trigger: "blur" }
        ],
        lastUpdateTime: [
          { required: true, message: "最后更新时间不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询大屏数据定位列表 */
    getList() {
      this.loading = true;
      listScreen_data(this.queryParams).then(response => {
        this.screen_dataList = response.rows;
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
        dataId: null,
        dataName: null,
        dataLocation: null,
        keyLabel: null,
        keyUnit: null,
        valueLabel: null,
        valueUnit: null,
        numPrecision: null,
        maxValue: null,
        minValue: null,
        dataColorId: null,
        lastUpdateUserId: null,
        lastUpdateTime: null
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
      this.ids = selection.map(item => item.dataId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加大屏数据定位";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const dataId = row.dataId || this.ids
      getScreen_data(dataId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改大屏数据定位";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.dataId != null) {
            updateScreen_data(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addScreen_data(this.form).then(response => {
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
      const dataIds = row.dataId || this.ids;
      this.$modal.confirm('是否确认删除大屏数据定位编号为"' + dataIds + '"的数据项？').then(function() {
        return delScreen_data(dataIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/screen_data/export', {
        ...this.queryParams
      }, `screen_data_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
