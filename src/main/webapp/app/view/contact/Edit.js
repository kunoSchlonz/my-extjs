Ext.define('HO.view.contact.Edit', {
    extend : 'Ext.window.Window',
    alias : 'widget.contactedit',
    title : 'Edit Contact',
    layout : 'fit',
    autoShow : true,
    listeners : {
        create : function(form, data) {
            console.log('create', form, data);
            //store.insert(0, data);
        }
    },
    initComponent : function() {
        this.items = [{
            xtype : 'form',
            items : [{
                xtype : 'textfield',
                name : 'shortName',
                fieldLabel : 'Name'
            }, {
                xtype : 'textfield',
                name : 'contactType',
                fieldLabel : 'Typ',
                value : 'FIRMA'
            }]
        }];

        this.buttons = [{
            text : 'Save',
            action : 'save'
        }, {
            text : 'Cancel',
            scope : this,
            handler : this.close
        }];

        this.callParent(arguments);
    }
});
