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
            }, /*
             'clientlist > toolbar > button' :{
             click : function (a,b,c){
             console.log('button',a,b,c);
             }
             },*/
            'clientlist button[action=add]' : {
                click : this.addUser
            },
            'clientlist' : {
                itemdblclick : this.editUser
            },
            'clientedit button[action=save]' : {
                click : this.updateClient
            }

        });
    },
    addUser : function(button) {
        var view = Ext.widget('clientedit', {
            title : 'Add User',
            intMode : 'add'
        });
    },
    editUser : function(grid, record) {
        console.log('Double clicked on ' + record.get('name'), grid);
        var view = Ext.widget('clientedit', {
            intMode : 'upd'
        });
        view.down('form').loadRecord(record);
    },
    updateClient : function(button) {
        console.log('clicked the Save button');
        var win = button.up('window'), form = win.down('form'), values = form.getValues();
        console.log(win);
        if (win.intMode == 'upd') {
            form.getRecord().set(values);
        } else {
            var v = this.getView('client.List');
            console.log(this.getStore('Client'));
            var g = Ext.ComponentQuery.query('clientlist');
            console.log(g);
            this.getStore('Client').insert(0, values);
        }

        win.close();
    },
    onPanelRendered : function() {
        console.log(this, 'The panel was rendered');
    }
});
