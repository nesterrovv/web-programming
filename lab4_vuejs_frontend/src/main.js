import * as Vue from 'vue';
import { createRouter, createWebHistory } from 'vue-router'
import App from "@/App.vue";
import Index from "@/components/Index";
import Main from "@/components/Main";
import NotFoundError from "@/components/Error";
import Notifications from '@kyvg/vue3-notification'
import 'flexboxgrid2'

const routes = [
    {
        path: '/',
        name: 'index-page',
        component: Index,
        beforeEnter: (to, from, next) =>
        {
            if (localStorage.getItem("par") !== null) {
                next({name: 'main-page'})
            } else next({name: 'auth-page'});
        }
    },
    {
        path: '/auth',
        name: 'auth-page',
        component: Index
    },
    {
        path: '/main',
        name: 'main-page',
        component: Main,
        beforeEnter: (to, from, next) =>
        {
            if (localStorage.getItem("par") !== null) {
                next()
            } else next({name: 'auth-page'});
        }
    },
    {
        path: '/*',
        name: 'error-page',
        component: NotFoundError,
        props: {
            default: true,
            errorCode: "404",
            errorMessage: "Page not found"
        }
    },
    {
        path: '/error-auth',
        name: 'error-auth',
        component: NotFoundError,
        props: {
            default: true,
            errorCode: "401",
            errorMessage: "No access to this page"
        }
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

Vue.createApp(App).use(router).use(Notifications).mount('#app');