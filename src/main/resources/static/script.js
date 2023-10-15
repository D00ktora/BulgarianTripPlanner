const wrapper = document.querySelector('.wrapper');
const logInLink = document.querySelector('.login-link');
const registerLink = document.querySelector('.register-link');
const btnLogin = document.querySelector('.btnLogin-popup');
const btnRegister = document.querySelector('.btnRegister-popup');
const iconClose = document.querySelector('.icon-close');
const registerError = document.querySelector('.invalid-feedback')


if (registerError.hasChildNodes()) {
    wrapper.classList.add('active-popup-register');
}

registerLink.addEventListener('click', ()=> {
    wrapper.classList.add('active');
})

logInLink.addEventListener('click', ()=> {
    wrapper.classList.remove('active');
})
btnLogin.addEventListener('click', ()=> {
    if (wrapper.classList.contains('active-popup-register')) {
    wrapper.classList.add('active-popup');
    wrapper.classList.remove('active-popup-register');
    } else {
        wrapper.classList.add('active-popup');
    }
})
iconClose.addEventListener('click', ()=> {
    wrapper.classList.remove('active-popup');
})
iconClose.addEventListener('click', ()=> {
    wrapper.classList.remove('active-popup-register');
})
btnRegister.addEventListener('click', ()=> {
    if (wrapper.classList.contains('active-popup')){
    wrapper.classList.add('active-popup-register');
    wrapper.classList.remove('active-popup');
    } else {
        wrapper.classList.add('active-popup-register');
    }
})