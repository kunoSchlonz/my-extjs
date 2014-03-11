Ext.define('HO.controller.Contact', {
    extend : 'Ext.app.Controller',
    views : ['contact.List', 'contact.Edit'],
    stores : ['Contact'],
    models : ['Contact'],
    init : function() {
        console.log('Initialized Users! This happens before the Application launch function is called');
        this.control({
            'viewport > panel' : {
                render : this.onPanelRendered
            }, /*
             'contactlist > toolbar > button' :{
             click : function (a,b,c){
             console.log('button',a,b,c);
             }
             },*/
            'contactlist button[action=add]' : {
                click : this.addUser
            },
            'contactlist' : {
                itemdblclick : this.editUser
            },
            'contactedit button[action=save]' : {
                click : this.updateContact
            }

        });
    },
    addUser : function(button) {
        var view = Ext.widget('contactedit', {
            title : 'Add User',
            intMode : 'add'
        });
    },
    editUser : function(grid, record) {
        console.log('Double clicked on ' + record.get('name'), grid);
        var view = Ext.widget('contactedit', {
            intMode : 'upd'
        });
        view.down('form').loadRecord(record);
    },
    updateContact : function(button) {
        console.log('clicked the Save button');
        var win = button.up('window'), form = win.down('form'), values = form.getValues();
        console.log(win);
        if (win.intMode == 'upd') {
            form.getRecord().set(values);
        } else {
            var v = this.getView('contact.List');
            console.log(this.getStore('Contact'));
            var g = Ext.ComponentQuery.query('contactlist');
            console.log(g);
            this.getStore('Contact').insert(0, values);
        }

        win.close();
    },
    onPanelRendered : function() {
        console.log(this, 'The panel was rendered');
    }
});
