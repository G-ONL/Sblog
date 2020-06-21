import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import router from '../router';
Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    token: '',
    isLoggedIn: false,
  },
  mutations: {
    login: (state, { token }) => {
      state.token = token;
      state.isLoggedIn = true;
    },
    loginFail: (state) => {
      state.token = '';
      state.isLoggedIn = false;
    }
  },
  actions: {
    login: (context, { userName, password }) => {
      axios
        .post('http://localhost:8080/user/login', { userName, password })
        .then(res => {
          if (res.status == 200) {
            // header에서 authorization 가져오기
            // 커밋하기
            context.commit('login',{ token: res.headers.authorization });
            router.push({name: 'Home'});
          } 
        })
        .catch(error => {
          console.log(error);
          context.commit('loginFail');
          alert("email, password 확인 해주세요!");
        });
    },
    signin:(context, {userName, password}) => {
      axios.post('http://localhost:8080/user/join',{
        userName, password
      })
        .then(res => {
          if(res.status == 200){
            // login으로 redirect 하기
          }
        });
    }
  }
});
