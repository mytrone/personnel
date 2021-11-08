<template>	
	<h3>发布招聘信息</h3>
	<div class="bod">
  <el-form ref="form" :model="form" label-width="100px">
		<!-- <el-form-item label="需求职位">
			<div style="width: 120px;">
				<el-input v-model="form.name"></el-input>
			</div>
		</el-form-item> -->
		<!-- <el-form-item label="发布人">
			<div style="width: 420px;">
				<el-input v-model="form.title"></el-input>
			</div>
		</el-form-item> -->
		<el-form-item label="招聘职位">
			<div style="width: 420px;">
				<el-input v-model="form.inf"></el-input>
			</div>
		</el-form-item>
		<el-form-item label="职位信息">
			<div style="width: 420px;">
				<el-input
				  type="textarea"
				  :rows="2"
				  placeholder="请输入内容"
				  v-model="form.information">
				</el-input>
			</div>
		</el-form-item>
		<el-form-item label="工作经验(年)">
			<div style="width: 420px;">
				<el-input v-model="form.workyear"></el-input>
			</div>
		</el-form-item>
    	<el-form-item label="工作地点">
    		<div style="width: 420px;">
    			<el-input v-model="form.address"></el-input>
    		</div>
    	</el-form-item>
    	<el-form-item label="联系电话">
    		<div style="width: 420px;">
    			<el-input v-model="form.tel"></el-input>
    		</div>
    	</el-form-item>
		<el-form-item label="薪资范围">
			<div style="width: 420px;">
				<el-input v-model="form.money"></el-input>
			</div>
		</el-form-item>
    <el-form-item>
      <el-button type="primary" @click="add()">发布</el-button>
    </el-form-item>
  </el-form>
  </div>
</template>

<script lang="ts">
import { Timer } from '@element-plus/icons'

export default {
  data() {
    return {
      form: {
		inf:'',
        information:'',
		workyear:'',
		address:'',
		tel:'',
		money:''
      },
    }
  },
  methods: {
    add() {
		console.log("水水水水水",this.form)
      this.axios.post("recruitDemand/insertDemand",{
		  demandPosition:this.form.inf,
		  demandAddress:this.form.address,
		  demandWorkyear:this.form.workyear,
		  demandPositionInf:this.form.information,
		  demandTel:this.form.tel,
		  demandMoney:this.form.money
	  }
	  ).then(res=>{
      	console.log("res",res)
      	if (res == 1) {
      	    alert("新增成功");
			this.form = {}
      	} else {
      	    alert("新增失败");
      	}
      }).catch(e=>{
      	console.log(e)
      })
  },created() {
	  
  }
},
}
</script>
<style>
	.bod{
		width: 50%;
	}
	body{text-align:center} 
</style>