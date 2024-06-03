(function () {
    const searchInput = document.getElementById('searchInput');
    const searchKeyWord = document.getElementById('searchKeyWord');
    const showMoreSearchResultBtn = document.getElementById('showMoreSearchResult');

    /**
     * Show result when user type in search input
     */
   searchInput.addEventListener('keyup', function (event) {
        event.preventDefault();

        const searchValue = searchInput.value;
        const searchUrl = `/api/search?q=${searchValue}`;
        const searchDataContainer = document.getElementById('searchDataContainer');

        searchKeyWord.innerText = searchValue;

        fetch(searchUrl)
            .then(response => response.json())
            .then(data => {
                if (data.data.length === 0) {
                    searchDataContainer.innerHTML = 'Không tìm thấy kết quả';
                    return;
                }

                let html = '<div class="row justify-content-between">';
                data.data.map(book => {
                    html += `
                    <div class="card mb-3 mx-2" style="max-width: 46%; padding-left: 0">
                      <div class="row g-0">
                        <div class="col-md-4">
                          <img src="${book.img}" class="img-fluid rounded-start" alt="Bìa sách">
                        </div>
                        <div class="col-md-8">
                          <div class="card-body">
                            <h5 class="card-title">${book.title}</h5>
                            <p class="card-text">${book.author}</p>
                            <a href="/product/${book.id}" class="btn btn-primary">Xem chi tiết</a>
                          </div>
                        </div>
                      </div>
                    </div> 
                  `
                });
                html += '</div>';
                searchDataContainer.innerHTML = html;
            });
    })

    /**
     * Show more search result
     */
    showMoreSearchResultBtn.addEventListener('click', function (event) {
        window.location.href = `/products?q=${searchInput.value}`;
    });
}());