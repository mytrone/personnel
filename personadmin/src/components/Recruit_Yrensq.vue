<template>
	<h3>用人申请单</h3>
	<div class="bod">
		<el-form ref="form" :model="form" label-width="100px">
			<!-- <el-form-item label="申请人">
			<div style="width: 120px;">
				<el-input v-model="form.name"></el-input>
			</div>
		</el-form-item> -->
			<el-form-item label="申请标题">
				<div style="width: 420px;">
					<el-input v-model="form.title"></el-input>
				</div>
			</el-form-item>
			<el-form-item label="需求岗位">
				<div style="width: 420px;">
					<el-input v-model="form.position"></el-input>
				</div>
			</el-form-item>
			<el-form-item label="需求人数">
				<div style="width: 420px;">
					<el-input v-model="form.num"></el-input>
				</div>
			</el-form-item>
			<el-form-item label="学历信息">
				<div style="width: 420px;">
					<el-select v-model="form.xueli" placeholder="请选择">
						<el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
						</el-option>
					</el-select>
				</div>
			</el-form-item>

			<el-form-item label="理由">
				<div style="width: 420px;">
					<el-input type="textarea" :rows="2" placeholder="请输入内容" v-model="form.eason">
					</el-input>
				</div>
			</el-form-item>



			<!-- </el-row> -->
			<el-form-item>
				<el-button type="primary" @click="add()">提交申请</el-button>
				<el-button type="primary" @click="qinkong()">清空信息</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script lang="ts">
	import {
		Timer
	} from '@element-plus/icons'

	export default {
		data() {
			return {
				options: [{
					value: '中专及以上',
					label: '中专及以上'
				}, {
					value: '高中及以上',
					label: '高中及以上'
				}, {
					value: '大专及以上',
					label: '大专及以上'
				}, {
					value: '本科及以上',
					label: '本科及以上'
				}, {
					value: '硕士研究生',
					label: '硕士研究生'
				}, {
					value: '博士研究生',
					label: '博士研究生'
				}],
				value: '',
				form: {
					title: '',
					position: '',
					num: '',
					xueli: '',
					eason: ''
				},
			}
		},
		methods: {



			qinkong() {
				this.form = {}
			},
			add() {
				console.log("水水水水水", this.form)

				this.axios.post("recruitRecruitapply/insertRecruitapply", {
					recruitapplyTitle: this.form.title,
					recruitapplyPosition: this.form.position,
					recruitapplyPnum: this.form.num,
					recruitapplyEducationInf: this.form.xueli,
					recruitapplyEason: this.form.eason
				}).then(res => {
					console.log("res", res)
					if (res == 1) {
						alert("新增成功");
					} else {
						alert("新增失败");
					}
				}).catch(e => {
					console.log(e)
				})
			},
			created() {

			}
		},
	}
</script>
<style>
	.bod {
		width: 50%;
	}

	body {
		text-align: center
	}
</style>
