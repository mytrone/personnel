<template>
	
	<el-row class="JNPF-common-search-box" :gutter="16">
		<el-form @submit.native.prevent>
			<el-col :span="12">
				<el-form-item label="流程标题">
					<el-input v-model="query.name" placeholder="请输入" clearable> </el-input>
				</el-form-item>
			</el-col>
			<el-col :span="12">
				<el-form-item label="日期">
					<el-date-picker v-model="query.arrivalDate" type="daterange" value-format="timestamp"
						format="yyyy-MM-dd" start-placeholder="开始日期" end-placeholder="结束日期">
					</el-date-picker>
	
				</el-form-item>
			</el-col>
			<el-col :span="12">
				<el-form-item>
					<el-button type="primary" icon="el-icon-search" @click="search()">查询</el-button>
				</el-form-item>
			</el-col>
			<el-col :span="12">
				<el-form-item>
					<el-button type="primary" icon="el-icon-search" @click="dialogVisible=true">创建流程</el-button>
				</el-form-item>
			</el-col>
	
	
	
		</el-form>
	</el-row>
	<el-table :data="tableData" style="width: 100%">
		<el-table-column label="Date" width="180">
			<template #default="scope">
				<el-icon>
					<timer />
				</el-icon>
				<span style="margin-left: 10px">{{ scope.row.date }}</span>
			</template>
		</el-table-column>
		<el-table-column label="Name" width="180">
			<template #default="scope">
				<el-popover effect="light" trigger="hover" placement="top">
					<template #default>
						<p>姓名: {{ scope.row.name }}</p>
						<p>住址: {{ scope.row.address }}</p>
					</template>
					<template #reference>
						<div class="name-wrapper">
							<el-tag size="medium">{{ scope.row.name }}</el-tag>
						</div>
					</template>
				</el-popover>
			</template>
		</el-table-column>
		<el-table-column label="Operations">
			<template #default="scope">
				<el-button size="mini" @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
				<el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">Delete</el-button>
			</template>
		</el-table-column>
	</el-table>
	<el-dialog
	    v-model="dialogVisible"
	    title="创建流程"
	    width="60%">
  <el-form ref="form" :model="form" label-width="120px">
    <el-form-item label="流程名称">
      <el-input v-model="flow.name"></el-input>
    </el-form-item>
    <el-form-item label="流程类型">
      <el-select v-model="OptionsType" placeholder="please select your zone">
        <el-option label="Zone one" value="shanghai"></el-option>
        <el-option label="Zone two" value="beijing"></el-option>
      </el-select>
    </el-form-item>
	<el-form-item label="发起职位 ">
	  <el-select v-model="OptionsPosition" placeholder="please select your zone">
	    <el-option label="Zone one" value="shanghai"></el-option>
	    <el-option label="Zone two" value="beijing"></el-option>
	  </el-select>
	</el-form-item>
	<el-form-item label="审批节点">
	      <el-checkbox-group v-model="checked">
	        <el-checkbox label="Online activities" name="type"></el-checkbox>
	        <el-checkbox label="Promotion activities" name="type"></el-checkbox>
	        <el-checkbox label="Offline activities" name="type"></el-checkbox>
	        <el-checkbox label="Simple brand exposure" name="type"></el-checkbox>
	      </el-checkbox-group>
	    </el-form-item>
		<el-form-item label="已选节点">
		      
		</el-form-item>
			
    
    <el-form-item label="Web地址">
      <el-input v-model="flow.adds" ></el-input>
    </el-form-item>
	<el-form-item label="是否启用">
	      <el-switch v-model="flow.state" active-color="#13ce66" inactive-color="#ff4949" />
	    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">Create</el-button>
      <el-button @click="dialogVisible=false">Cancel</el-button>
    </el-form-item>
  </el-form>
    </el-dialog>
</template>

<script lang="ts">
export default {
  data() {
    return {
		dialogVisible:false,
		OptionsPosition:[],
		OptionsType:[],
		query: '',
		checked:[],
		flow:{
			name:'',
			adds:'',
			state:true,
		}
    }
  },
  methods: {
    onSubmit() {
      console.log('submit!')
    },
  },
}
</script>
