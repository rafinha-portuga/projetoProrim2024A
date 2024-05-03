(function() {
    $("#tabclientes").on("click",".js-delete",function() {
        // alert("clicou")
        let botaocliente = $(this)
        $("#btnsim").attr("data-id",botaocliente.attr("data-id"))
        $("#modalcliente").modal("show")
    })
    $("#btnsim").on("click", function(){
        let botaosim = $(this)
        let id = botaosim.attr("data-id")
        $.ajax({
            url: "/clientes/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href = "/clientes"
            }
        })
    })
})()