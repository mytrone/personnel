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
		<el-table-column label="编号" width="180">
			<template #default="scope">
				
				<span style="margin-left: 10px">{{ scope.row.date }}</span>
			</template>
		</el-table-column>
		<el-table-column label="流程名称" width="180">
			<template #default="scope">
				
				<span style="margin-left: 10px">{{ scope.row.date }}</span>
			</template>
		</el-table-column>
		<el-table-column label="web地址" width="180">
			<template #default="scope">
				
				<span style="margin-left: 10px">{{ scope.row.date }}</span>
			</template>
		</el-table-column>
		<el-table-column label="创建时间" width="180">
			<template #default="scope">
				
				<span style="margin-left: 10px">{{ scope.row.date }}</span>
			</template>
		</el-table-column>
		<el-table-column label="状态" width="180">
			<template #default="scope">
				
				<span style="margin-left: 10px">{{ scope.row.date }}</span>
			</template>
		</el-table-column>
		
		<el-table-column label="操作">
			<template #default="scope">
				<el-button size="mini" @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
				<el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">Delete</el-button>
			</template>
		</el-table-column>
	</el-table>
	<el-dialog v-model="dialogVisible" title="创建流程" width="60%">
		<el-form ref="form" :model="form" label-width="120px">
			<el-form-item label="流程名称">
				<el-input v-model="flow.name"></el-input>
			</el-form-item>
			<el-form-item label="流程类型">
				<el-select v-model="OptionsType" placeholder="请选择类型">
					
					<template v-for="item in option">
						  <el-option :label="item.alinkeyName" :value="item.alinkeyId"></el-option>
					</template>
				</el-select>
				
				
			</el-form-item>
			<el-form-item label="发起职位 ">
				<el-select v-model="OptionsPosition" placeholder="please select your zone">
					<el-option label="Zone one" value="shanghai"></el-option>
					<el-option label="Zone two" value="beijing"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="审批节点">
				<el-checkbox-group class="checkbox-group" flex="wrap:wrap" v-model="handleArr">
					
					<el-checkbox v-for="(item, index) in tableData" :label="item" :key="index" border>
						{{ item}}
					</el-checkbox>
				</el-checkbox-group>
			</el-form-item>
<el-form-item label="已选节点">
	<template v-for="item in handleArr">
		
		<span style="margin-right: 10px;">
			{{item}}
		</span>
	</template>
		      
		</el-form-item>


			<el-form-item label="Web地址">
				<el-input v-model="flow.adds"></el-input>
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
	import qs from 'qs'
	export default {
		data() {
			return {
				option:[],
				tableData: ['Shanghai', 'Beijing', 'Guangzhou', 'Shenzhen'],
				dialogVisible: false,
				OptionsPosition: [],
				OptionsType: [],
				query: '',
				checked: [],
				flow: {
					name: '',
					adds: '',
					state: true,
				},
				handleArr: [], // 选中的数组

			}
		},
		methods: {
			onSubmit() {
				console.log('submit!')
			},SelectType(ids){
				//查询类别
				let prim={
					id:ids
				};
				let qsprim=qs.stringify(prim);
				this.axios.get("type/select",qsprim).then(res=>{
					this.option=res.data;
				})
			}
		},created() {
			this.SelectType(1);
		}
	}
</script>
