let data = [];
$.ajax({
    type: 'GET',
    url: 'data/products.json',
    data: data,
    dataType: 'json',
    success: function (data) {
        console.log(data);
        $.each(data, function (index, element) {
            $('body').append($('<div>', {
                text: element.name
            }));
        });
    }
})