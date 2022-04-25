import Vuex from 'vuex';
//import axios from 'axios';
const storage = new Vuex.Store({
    state: {
        auth: {
            token: localStorage.getItem('jwtToken') || '',
            username: localStorage.getItem('username') || '',
            id: localStorage.getItem('userId') || -1,
        }
    },
    mutations: {
        setJwtToken(state, token) {
            localStorage.setItem('jwtToken', token);
            state.auth.token = token;
        },
        setUsernameToken(state, name) {
            localStorage.setItem('username', name);
            state.auth.username = name;
        },
        setUserId(state, id) {
            localStorage.setItem('userId', id);
            state.auth.id = id;
        },
    },
    actions: {

    }
});
export default storage;