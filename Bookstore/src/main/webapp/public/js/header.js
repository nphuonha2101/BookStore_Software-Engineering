(function() {

    const openSideMenuBtn = document.getElementById('openSideMenuBtn');
    const closeSideMenuBtn = document.getElementById('closeSideMenuBtn');
    const overlay = document.querySelector('.overlay');
    const headerAside = document.getElementById('headerAside');
    const headerToggleAuthAction = document.getElementById('headerToggleAuthAction');
    const authAction = document.querySelector('.auth-action');
    const searchForm = document.getElementById('searchForm');

    let options = {
        keyboard: false,
        focus: true,
        backdrop: 'static'
    };
    const searchModal = new bootstrap.Modal(document.getElementById('searchModal'), options)

    const openSidebar = function () {
        overlay.classList.add('show');
        headerAside.classList.add('show');
    }

    const closeSidebar = function () {
        overlay.classList.remove('show');
        headerAside.classList.remove('show');
    }

    openSideMenuBtn.addEventListener('click', function() {
        openSidebar();
    });

    overlay.addEventListener('click', function() {
        if(!headerAside.classList.contains('show') || !overlay.classList.contains('show')) return;
        closeSidebar();
    });

    closeSideMenuBtn.addEventListener('click', function() {
        closeSidebar();
    });

    headerToggleAuthAction.addEventListener('click', function() {
        authAction.classList.toggle('show');
    });

    searchForm.addEventListener('focusin', function() {
        searchModal.show();
    });
})();
