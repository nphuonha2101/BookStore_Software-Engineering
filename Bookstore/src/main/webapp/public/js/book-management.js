$((function () {
    const booksTable = $('#booksTable');

    const table = booksTable.DataTable({
        "processing": true,
        "serverSide": true,
        "ajax": {
            "url": "/api/dataTable/books",
            "dataSrc": "data"
        },
        "columns": [
            {"data": "id"},
            {"data": "title"},
            {"data": "author"},
            {"data": "publisher"},
            {
                "data": "categories", orderable: false,
                render: function (data, type, row) {
                    return data.map(function (category) {
                        return category.name;
                    }).join(", ");
                }
            },
            {
                "data": "price",
                render: function (data, type, row) {
                    return new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'VND'}).format(data);
                }
            },
            {"data": "isbn", orderable: false},
            {
                "data": null,
                render: function (data, type, row) {
                    return "<button class='btn btn-primary edit-button'>Chỉnh sửa</button>";
                }
            },
            {
                "data": null,
                render: function (data, type, row) {
                    return "<button class='btn btn-danger delete-button'>Xóa</button>";
                }
            },
        ]
    });

    booksTable.on('click', 'button.delete-button', function () {
        const data = table.row($(this).closest('tr')).data();

        console.log(data)
        if (confirm(`Bạn có muốn xóa sách này không: ${data.title}?`)) {
            $.ajax({
                    url: '/api/dataTable/books?id=' + data.id,
                    type: 'DELETE',

                    success: function (response) {
                        table.ajax.reload();
                        alert(response.message);

                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        console.log(jqXHR.responseText)
                    }

                }
            )
        }
    });

    booksTable.on('click', '.edit-button', function () {
        const data = table.row($(this).closest('tr')).data();
        console.log(data);

        $('#method').val('PATCH');
        $('#bookModalLabel').text('Chỉnh sửa sách');
        $('#id').val(data['id']);
        $('#title').val(data['title']);
        $('#author').val(data['author']);
        $('#publisher').val(data['publisher']);
        $('#categories').val(data['categories'].map(function (category) {
            return category.id;
        }));
        $('#price').val(data['price']);
        $('#img').val(data['img']);
        $('#isbn').val(data['isbn']);
        $('#summary').val(data['summary']);
        $('#img-preview').attr('src', data['img']);

        let options = {
            backdrop: 'static',
            keyboard: false,
            focus: true
        };

        const bookModal = new bootstrap.Modal(document.getElementById('bookModal'), options)
        bookModal.show();
    });

    $('.add-button').on('click', function () {

        $('#method').val('POST');
        $('#bookModalLabel').text('Thêm sách');
        $('#id').val('');
        $('#title').val('');
        $('#author').val('');
        $('#publisher').val('');
        $('#categories').val('');
        $('#price').val('');
        $('#img').val('');
        $('#isbn').val('');
        $('#summary').val('');

        let options = {
            backdrop: 'static',
            keyboard: false,
            focus: true
        };

        const bookModal = new bootstrap.Modal(document.getElementById('bookModal'), options)
        bookModal.show();
    });

    $('#categoriesSelect').on('change', function () {
        const categoryValuesInput = $('#categoryValues');

        let categoryValues = [];
        $('#categoriesSelect option:selected').each(function () {
            categoryValues.push($(this).val());
        });

        categoryValuesInput.val(categoryValues).join(',');
        alert(categoryValuesInput.val());
    })

    $('.submit-form-btn').click(function () {
        const formData = new FormData($('#book-form')[0]);
        const method = $('#method').val();

        $.ajax({
            url: '/api/dataTable/books',
            type: method,
            data: formData,
            processData: false,
            contentType: false,

            success: function (response) {
                table.ajax.reload();
                alert(response.message);
                $('#bookModal').modal('hide');
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(jqXHR.responseText)
            }
        });
    });

    $('#img').on('input', function () {
        let src = $(this).val();
        $('#img-preview').attr('src', src);
    });


}));