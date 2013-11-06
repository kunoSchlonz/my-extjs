Ext.define('HO.controller.Client', {
    extend : 'Ext.app.Controller',
    views : ['client.List', 'client.Edit'],
    stores : ['Client'],
    models : ['Client'],
    init : function() {
        console.log('Initialized Users! This happens before the Application launch function is called');
        this.control({
            'viewport > panel' : {
                render : this.onPanelRendered
            },
            'clientlist' : {
                itemdblclick : this.editUser
            },
            'clientedit button[action=save]' : {
                click : this.updateClient
            }

        });
    },
    editUser : function(grid, record) {
        console.log('Double clicked on ' + record.get('name'), grid);
        var view = Ext.widget('clientedit');
        view.down('form').loadRecord(record);
    },
    updateClient : function(button) {
        console.log('clicked the Save button');
        var win = button.up('window'), form = win.down('form'), record = form.getRecord(), values = form.getValues();

        record.set(values);
        win.close();
    },
    onPanelRendered : function() {
        console.log('The panel was rendered');
    }
});
