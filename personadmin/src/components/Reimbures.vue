<template>
	<div style="margin: 0 auto;width: 98%;">
		<el-button @click="add">新增出差报销</el-button>
	</div>
</template>

<script>
	import moment from 'moment'
	import {
		ElMessageBox,
		ElNotification,
		ElMessage
	} from 'element-plus'
	import qs from 'qs'

	export default {
		data() {
			return {

			}
		},
		methods: {
			add() {
				this.$router.push({
					name:'clockinginreimburse'
				})
			}
		},
		mounted() {

		}
	}
</script>

<style>
</style>
