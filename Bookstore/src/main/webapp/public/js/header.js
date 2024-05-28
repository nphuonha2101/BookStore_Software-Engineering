(function() {

    const openSideMenuBtn = document.getElementById('openSideMenuBtn');
    const closeSideMenuBtn = document.getElementById('closeSideMenuBtn');
    const overlay = document.querySelector('.overlay');
    const headerAside = document.getElementById('headerAside');
    const headerToggleAuthAction = document.getElementById('headerToggleAuthAction');
    const authAction = document.querySelector('.auth-action');
    const openSearchBtn = document.querySelector('.open-search');
    const searchInput = document.querySelector('.search-absolute');

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

    openSearchBtn.addEventListener('click', function(e) {
        if(searchInput.classList.contains('show')) {
            if(e.target !== searchInput) {
                searchInput.classList.remove('show');
                return;
            }
        } else {
            searchInput.classList.add('show');
        }
    });

    searchInput.addEventListener('focusout', function(e) {
        searchInput.classList.remove('show');
        e.currentTarget.value = '';
    });
})();