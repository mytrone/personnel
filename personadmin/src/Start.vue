<template>
	<router-view></router-view>
</template>

<script>
	/* 
	 1、页面刷新前的触发事件beforeunload
		将state中的数据暂时存储到sessionStorage中
	 2、Vue的钩子函数中，将sessionStorage中的值，赋值给state
		sessionStorage清空
	 */
	export default{
		data(){
			return{
				
			}
		},
		methods:{
			
		},
		created(){	
			//判断sessionStorage中键state有没有值
			if(sessionStorage.getItem("state")){
				let mystate = JSON.parse(sessionStorage.getItem("state"))
				this.$store.replaceState(
					Object.assign(
						{},
						this.$store.state,
						mystate
					)
				)
				sessionStorage.removeItem("state");
				
			}
		},
		mounted() {
		  window.addEventListener('beforeunload', () => {
		    //this.$store.state.children={}		
		    //刷新前将目前登录的用户保存到sessionStorage中
		    sessionStorage.setItem('state', JSON.stringify(this.$store.state))
		  })
		}
		
	}
</script>


<style>
</style>
