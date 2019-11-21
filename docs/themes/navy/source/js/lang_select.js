(function () {
    'use strict';

    function changeLang() {
        var lang = this.value;
        var canonical = this.dataset.canonical;
        // if (lang === 'en') lang = '';
        if (lang) lang += '/';
        console.log(canonical)
        location.href = 'http://athena.incubator.inke.io/' + lang + canonical;
    }

    document.getElementById('lang-select').addEventListener('change', changeLang);
    document.getElementById('mobile-lang-select').addEventListener('change', changeLang);
})();
