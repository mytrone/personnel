<template>
	<el-row class="JNPF-common-search-box" :gutter="16">


	</el-row>
	<el-tabs v-model="activeName" @tab-click="handleClick">
		<el-tab-pane label="新建评分模板" name="first">
			<el-col :span="12">
				<el-button @click="drawer=true">
					查看模板项目
				</el-button>
			</el-col>
			<el-form :model="financeTemplate" ref="financeTemplate" :rules="treatmentCardRules">
				<el-col :span="6" :push="1">
					 <el-form-item  label="考核类别" :label-width="formLabelWidth" prop="alinkeyId">
						<el-select v-model="financeTemplate.alinkeyId" filterable placeholder="请选择模板类别"
							style="width: 150px;margin-bottom: 8px;margin-right: 800px;" >
							<el-option v-for="item in sortw" :key="item.alinkeyId" :label="item.alinkeyName"
								:value="item.alinkeyId">
							</el-option>
						</el-select>
					</el-form-item>	
				</el-col>
				<el-col :span="7" :push="1">
					<el-form-item label="模板名字" prop="templateName">
						<el-input v-model="financeTemplate.templateName"></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="5" :push="4">
					<el-button @click="AddBatch()">
						确定
					</el-button>
				</el-col >
			</el-form>		
			<el-table :data="financeTemplate.financeItem" style="width:100%" :header-cell-style="{'text-align':'center'}"
				:cell-style="{'text-align':'center'}">
				
				<el-table-column label="项目名" prop="itemName">
					
				</el-table-column>
				<el-table-column label="项目说明" prop="itemExplain">
					
				</el-table-column>
				<el-table-column label="操作">
					<template #default="scope">
						<el-button type="primary" size="medium" @click="delDrug2(scope.$index)"
							style="margin:  0  auto;">删除
						</el-button>
					</template>
				</el-table-column>
				<!-- <el-table-column label="Operations">
						<template #default="scope">
							<el-button size="mini" @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
							<el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">Delete</el-button>
						</template>
					</el-table-column> -->
			</el-table>
		</el-tab-pane>
		<el-tab-pane label="查看评分模板" name="second">
			<el-form @submit.native.prevent>
				<el-col :span="12">
					<el-form-item label="考核项目">
						<el-input v-model="financeItem.itemName" placeholder="请输入项目名查询"> </el-input>
					</el-form-item>
					
				</el-col>
				<el-col :span="12" :push="1">
					<el-form-item>
						<el-button type="primary"  @click="getFinanceItem()">查询</el-button>
					</el-form-item>
				</el-col>
				
				
				<el-table :data="item" style="width:100%" :header-cell-style="{'text-align':'center'}"
					:cell-style="{'text-align':'center'}">
					<el-table-column label="序号" prop="itemId">
					</el-table-column>
					<el-table-column label="项目名" prop="itemName">

					</el-table-column>
					<el-table-column label="项目说明" prop="itemExplain">
					</el-table-column>
					<el-table-column label="操作">
						<template #default="scope">
							<el-button type="primary" size="medium" @click="delDrugw(scope.row)"
								style="margin:  0  auto;">删除
							</el-button>
						</template>
					</el-table-column>
					<!-- <el-table-column label="Operations">
						<template #default="scope">
							<el-button size="mini" @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
							<el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">Delete</el-button>
						</template>
					</el-table-column> -->
				</el-table>


			</el-form>
		</el-tab-pane>
		<el-drawer title="项目列表" v-model="drawer" size="50%">
						<el-col :span="7" :push="1">
							<el-input v-model="financeItem.itemName" placeholder="请输入项目名查询"> </el-input>
						</el-col>
						<el-col :span="7" id="shuru1" :push="2">
							<el-row>
								<el-button type="primary"  @click="getFinanceItem()">查询</el-button>
							</el-row>
						</el-col>
						<div style="height: 300px;">
							<el-table :data="item" style="width:100%" :header-cell-style="{'text-align':'center'}"
								:cell-style="{'text-align':'center'}">
								<el-table-column label="序号" prop="itemId">
								</el-table-column>
								<el-table-column label="项目名" prop="itemName">
							
								</el-table-column>
								<el-table-column label="项目说明" prop="itemExplain">
								</el-table-column>
								<el-table-column label="操作">
									<template #default="scope">
										<el-button type="primary" size="medium" @click="delDrugTj(scope.row)"
											style="margin:  0  auto;">添加
										</el-button>
									</template>
								</el-table-column>
							</el-table>
						</div>
					</el-drawer>
	</el-tabs>


</template>

<script lang="ts">
	import {
		Timer
	} from '@element-plus/icons'

	export default {
		components: {
			Timer,
		},
		data() {
			return {
				activeName: 'first',
				drawer:false,
				query: '',
				
				tableData: [], //新增数组
				item: [], //考核项目查询数组
				sortw :[],//类别表数据
				financeItem: {
					itemId: '', //id
					itemName: '', //项目名
					itemExplain: '', //项目说明
				},
				financeTemplate:{//模板属性
					templateId: '',//主键
				    empId: '',//员工id
					alinkeyId: '',//类别id
					templateSerial: '',//模板编号
				    templateName: '',//模板名
					financeItem:[]
				},
				treatmentCardRules: {
					templateName: [{
						required: true,
						message: '请输入模板名',
						trigger: 'change'
					}],
					alinkeyId: [{
						required: true,
						message: '请选择类别',
						trigger: 'change'
					}],
				}
				


			}
		},
		methods: {
			Addrow() { //新增一行空表数据
				this.tableData.push({
					itemName: '',
					itemExplain: ''
				})
			},
			AddBatch() { //新增项目
				this.$confirm('是否新增?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					for (var i = 0; i < this.tableData.length; i++) {
						this.financeItem.itemName = this.tableData[i].itemName;
						this.financeItem.itemExplain = this.tableData[i].itemExplain;
						this.axios.post("/finance/addFinance", this.financeItem).then((res) => {

							if (res.data === "ok") {
								this.$message.success("新增成功");
								this.getQC()
							} else {
								this.$message.error("新增失败");
							}
							console.log(v.data)
						}).catch(function() {

						})
					}
				}).catch(() => {
					this.$message({
						type: 'info',
						message: '已取消重置'
					});
				});
			},
			getFinanceItem() {
				this.axios.post("/finance/allFinance", this.financeItem).then((res) => {
					this.item = res.data;
				}).catch(function() {

				})
			},
			
			delDrugTj(row){//添加项目数据
				this.financeTemplate.financeItem.push(row)
			},
			delDrugw(row) { //删除项目表项目

				this.financeItem.itemId = row.itemId;

				this.$confirm('是否删除?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {


					this.axios.post("/finance/deFinances", this.financeItem).then((res) => {

						if (res.data === "ok") {
							this.$message.success("删除成功");
							this.getFinanceItem()
						} else {
							this.$message.error("删除失败");
						}
						console.log(v.data)
					}).catch(function() {

					})

				}).catch(() => {
					this.$message({
						type: 'info',
						message: '已取消重置'
					});
				});

			},
				
			getClickw(){//查询类别表
				this.axios.post("/finance/allAlinkey").then((res) => {
					this.sortw = res.data;
				}).catch(function() {
				
				})
			},
			get
			delDrug2(index) { //删除编辑

				this.financeTemplate.financeItem.splice(index, 1);
			},
			getQC() {
				for (var i = 0; i < this.financeTemplate.financeItem.length; i++) {
					this.financeTemplate.financeItem.splice(i);
				}
			},
			getTemplate(){//添加模板
				this.$refs['hospital'].validate((valid) => {
					
					if (valid) {
						this.axios.post('/ju/zhe', this.hospital).then((v) => {
							
						}).catch(function() {

						})
					} else {
						this.$message.error("请输入必填项");
						return false;
					}
				})
			},
			handleClick(tab, event) {
				console.log(tab, event)
			},
			handleEdit(index, row) {
				console.log(index, row)
			},
			handleDelete(index, row) {
				console.log(index, row)
			},
		},
		created() {
			this.getFinanceItem()
			this.getClickw()

		}
	}
</script>
