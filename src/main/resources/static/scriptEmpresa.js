(function() {
    $("#tabempresas").on("click",".js-delete",function() {
        // alert("clicou")
        let botaoempresa = $(this)
        $("#btnsim").attr("data-id",botaoempresa.attr("data-id"))
        $("#modalempresa").modal("show")
    })
    $("#btnsim").on("click", function(){
        let botaosim = $(this)
        let id = botaosim.attr("data-id")
        $.ajax({
            url: "/empresas/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href = "/empresas"
            }
        })
    })
})()