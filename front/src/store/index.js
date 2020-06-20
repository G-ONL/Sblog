import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    token: '',
    isLoggedIn: false,
  },
  mutations: {
    login: (state, {token}) => {
      state.token = token;
      state.isLoggedIn = true;
    },
    loginFail: (state) => {
      state.token = '';
      state.isLoggedIn = false;
    }
  },
  actions: {
    login: (context, {email, password}) => {
      console.log(email,password);
      axios.post('https://reqres.in/api/login',{
          email, password
        })
        .then(res=>{
          console.log(res);
          if(res.status == 200){
            context.commit('login',{token:101010});
          }
        }
          );
    }
  }
});
