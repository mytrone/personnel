<template>
	<el-row class="JNPF-common-search-box" :gutter="16">


	</el-row>
	<el-tabs v-model="activeName" @tab-click="handleClick">
		<el-tab-pane label="新增项目" name="first">
			<el-col :span="12">
				<el-button @click="Addrow()">
					新增编辑行
				</el-button>
				<el-button @click="AddBatch()">
					确定
				</el-button>
			</el-col>
			<el-table :data="tableData" style="width:100%" :header-cell-style="{'text-align':'center'}"
				:cell-style="{'text-align':'center'}">
				<el-table-column label="项目名" prop="itemName">
					<template v-slot:default="scope">
						<el-input v-model="scope.row.itemName"></el-input>
					</template>
				</el-table-column>
				<el-table-column label="项目说明" prop="itemExplain">
					<template v-slot:default="scope">
						<el-input v-model="scope.row.itemExplain"></el-input>
						<!-- <el-popover effect="light" trigger="hover" placement="top">
								<template #default>
									<p>姓名: {{ scope.row.name }}</p>
									<p>住址: {{ scope.row.address }}</p>
								</template>
								<template #reference>
									<div class="name-wrapper">
										<el-tag size="medium">{{ scope.row.name }}</el-tag>
									</div>
								</template>
							</el-popover> -->
					</template>
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
		<el-tab-pane label="查询项目" name="second">
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
				query: '',
				tableData: [], //新增数组
				item: [], //考核项目查询数组
				financeItem: {
					itemId: '', //id
					itemName: '', //项目名
					itemExplain: '', //项目说明
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

							if (res === "ok") {
								this.$message.success("新增成功");
								this.getQC()
							} else {
								this.$message.error("新增失败");
							}
							
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
					this.item = res;
				}).catch(function() {

				})
			},
			getQC() {
				for (var i = 0; i < this.tableData.length; i++) {
					this.tableData.splice(i);
				}
			},
			delDrugw(row) { //删除项目表项目

				this.financeItem.itemId = row.itemId;

				this.$confirm('是否删除?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {


					this.axios.post("/finance/deFinances", this.financeItem).then((res) => {

						if (res === "ok") {
							this.$message.success("删除成功");
							this.getFinanceItem()
						} else {
							this.$message.error("删除失败");
						}
						
					}).catch(function() {

					})

				}).catch(() => {
					this.$message({
						type: 'info',
						message: '已取消重置'
					});
				});

			},
			delDrug2(index) { //删除编辑

				this.tableData.splice(index, 1);
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

		}
	}
</script>
