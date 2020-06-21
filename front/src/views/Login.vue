<template>
    <div class="total">
        <div class="center_column">
            <img class="sblog_image" src="https://ifh.cc/g/LnCMoH.jpg" />
            <div class="login_comment">
                <span>Log in to Sblog</span>
            </div>
            <div class="login_box">
                <div class="text_row">
                    <span>Username or email address</span>
                </div>
                <input class="input_row" v-model="userName"/>
                <div class="text_row">
                    <span>Password</span>
                </div>
                <input class="input_row" v-model="password" type="password"/>
                <button class="sign_in_button" v-on:click="login">Log in</button>
            </div>
            <div class="sign_up_box"></div>
        </div>
    </div>
</template>
<script>
export default {
    data() {
        return {
            userName: '',
            password: ''
        }
    },
    methods: {
        login: function(){
            const {userName, password} = this;
            this.$store.dispatch('login',{userName, password});
        }
    },
};
// email, password를 템플릿과 v-model로 연결 한다
// methods 안에서 send함수를 만든다
//      그 안에서 login으로 쿼리를 날린다
</script>
<style>
        *:hover{
            outline:none;
        }
        *:not( :hover ){
            outline:none;
        }
        button:hover{
            opacity: 0.9;
        }
        body{
            background-color: rgb(249, 249, 249);
        }
        .total {
            width: 100%;
            height: 100%;
            display: flex;
            justify-content: center;
            align-items: left;
        }

        .center_column {
            margin-top: 5vh;

            width: 30%;
            min-width: 100px;
            height: 100%;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: left;
        }

        .sblog_image {
            margin-top: 13vh;
            width: 50px;
            height: 50px;
            background-color: rgba(255, 255, 255, 0);
            border-radius: 50%;
        }

        .login_comment {
            margin: 30px;
            font-size: 30px;
            font-weight: 400;
        }

        .login_box {
            padding: 25px 30px;
            width: 320px;
            background-color: white;
            border: 1px solid rgb(228, 228, 228);
            border-radius: 7px;
        }

        .text_row {
            margin-bottom: 10px;
            font-weight: 600;
        }

        .input_row {
            width: 100%;
            height: 35px;
            margin-bottom: 15px;
            border: 1px solid rgb(228, 228, 228);
        }

        .sign_in_button {
            width: 100%;
            height: 38px;
            font-weight: 700;
            background-color: rgb(57, 88, 94);
            color: white;
            border: 1px solid;
            border-radius: 5px;
        }
</style>