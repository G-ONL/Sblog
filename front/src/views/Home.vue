<template>
<div>
  <div>this is Home</div>
  <div>true or not: {{this.$store.state.isLoggedIn}}</div>
  <input type="text" v-model="email"/>
  <input type="text" v-model="password"/>
  <button v-on:click="send">send</button>
</div>
</template>

<script>
export default {
  data:function(){
    return{
      email: '',
      password: '',
    };
  },
  methods: {
    send:function(){
      this.$store.dispatch('login',{email: this.email, password:this.password});
    }
  },
  name: "Home"
};
</script>
