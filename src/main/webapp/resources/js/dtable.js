$(function() {
    $('#table').DataTable({
        'bStateSave':true,
        /*"scrollY":        "600px", //высота таблицы
            "scrollCollapse": true,
        */    "paging":         true,
        /*"dom": 'C<"clear">lfrtip',
        "oColVis": {
            "buttonText": "Скрыть/показать колонки"
        },*/
        /*initComplete: function () {
            this.api().columns().every( function () {
                var column = this;
                var select = $('<select ><option value="" class="checkbox-inline"></option></select>')
                    .appendTo( $(column.header()) )
                    .on( 'change', function () {
                        var val = $.fn.dataTable.util.escapeRegex(
                            $(this).val()
                        );
                        column
                            .search( val ? '^'+val+'$' : '', true, false )
                            .draw();
                    } );
                $( select ).click( function(e) {
                    e.stopPropagation();
                });
                //default
            /!*    column.data().unique().sort().each( function ( d, j ) {
                    select.append( '<option value="'+d+'">'+d+'</option>' )
                } );*!/
                /!*column
                    .data()
                    .unique()
                    .sort()
                    .each(function(d, j) {
                        var val = $.fn.dataTable.util.escapeRegex(d);
                        if (column.search() === "^" + val + "$") {
                            select.append(
                                '<option value="' + d + '" selected="selected">' + d + "</option>"
                            );
                        } else {
                            select.append('<option value="' + d + '">' + d + "</option>");
                        }
                    });*!/
            } );
        }*/
    } );
});