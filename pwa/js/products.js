let data = [];
$.ajax({
    type: 'GET',
    url: 'data/products.json',
    data: data,
    dataType: 'json',
    success: function (data) {
        $.each(data, function (index, product) {
            const card = '<div class="my-3">' +
                "<div class='card' style='width: 18rem; margin: auto;'>" +
                "<div class='card-body'>" +
                "<img class='card-img-top' src='" + product.image + "' alt='Product image'></img>" +
                "<h5 class='card-title'>" + product.name + "</h5>" +
                "<p class='card-text'><b>Description: </b>" + product.description + "</p>" +
                "<p class='card-text'><b>Price: </b>" + product.price + "</p>" +
                "</div>" +
                "<div class='card-footer'><a href='#' class='btn btn-primary'>Buy</a></div>" +
                "</div></div>";
            switch (index % 3) {
                case 0:
                    $("#col-1").append(
                        card
                    )
                    break;
                case 1:
                    $("#col-2").append(
                        card
                    )
                    break;
                case 2:
                    $("#col-3").append(
                        card
                    )
                    break;
            }
        });
    }
})