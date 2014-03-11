Ext.define('HO.view.contact.List', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.contactlist',
	dockedItems : [{
		xtype : 'toolbar',
		items : [{
			glyph : 'xf055@FontAwesome',
			text : 'Add',
			action : 'add'
		}]
	}, {
		weight : 2,
		xtype : 'toolbar',
		dock : 'bottom',
		items : [{
			xtype : 'tbtext',
			text : '<b>Config: </b>'
		}, '|', {
			text : 'autoSync',
			enableToggle : true,
			pressed : true,
			glyph : 'xf046@FontAwesome',
			tooltip : 'When enabled, Store will execute Ajax requests as soon as a Record becomes dirty.',
			scope : this,
			toggleHandler : function(btn, pressed) {
				if(pressed) {
					btn.setGlyph('xf046@FontAwesome');
				} else {
					btn.setGlyph('xf096@FontAwesome');
				}
				var s = Ext.StoreMgr.get("Contact");
				s.autoSync = pressed;
			}
		}, {
			text : 'batch',
			enableToggle : true,
			pressed : true,
			glyph : 'xf046@FontAwesome',
			tooltip : 'When enabled, Store will batch all records for each type of CRUD verb into a single Ajax request.',
			scope : this,
			toggleHandler : function(btn, pressed) {
				if(pressed) {
					btn.setGlyph('xf046@FontAwesome');
				} else {
					btn.setGlyph('xf096@FontAwesome');
				}
				var s = Ext.StoreMgr.get("Contact");

				s.getProxy().batchActions = pressed;
			}
		}, {
			text : 'writeAllFields',
			enableToggle : true,
			pressed : false,
			glyph : 'xf096@FontAwesome',
			tooltip : 'When enabled, Writer will write *all* fields to the server -- not just those that changed.',
			scope : this,
			toggleHandler : function(btn, pressed) {
				if(pressed) {
					btn.setGlyph('xf046@FontAwesome');
				} else {
					btn.setGlyph('xf096@FontAwesome');
				}
				var s = Ext.StoreMgr.get("Contact");
				s.getProxy().getWriter().writeAllFields = pressed;
			}
		}]
	}, {
		weight : 1,
		xtype : 'toolbar',
		dock : 'bottom',
		ui : 'footer',
		items : ['->', {
			glyph : 'xf0ee@FontAwesome',
			text : 'Sync',
			scale : 'large',
			scope : this,
			handler : function() {
				var s = Ext.StoreMgr.get("Contact");
				s.sync();

			}
		}]
	}],
	title : 'All Contacts',
	store : 'Contact',
	initComponent : function() {

		this.columns = [{
			header : 'id',
			dataIndex : 'id',
			flex : 1
		}, {
			header : 'Name',
			dataIndex : 'shortName',
			flex : 1
		}, {
			header : 'Typ',
			dataIndex : 'contactType',
			flex : 1
		}, {
			menuDisabled : true,
			sortable : false,
			xtype : 'actioncolumn',
			width : 50,
			items : [{
				glyph : 'xf046@FontAwesome',
				tooltip : 'Sell stock',
				text : 'nothing',
				handler : function(grid, rowIndex, colIndex) {
					var rec = grid.getStore().getAt(rowIndex);
					console.log('test');
					Ext.Msg.alert('Sell', 'Sell ' + rec.get('contactType'));
				}
			}]
		},
		// next btn
		{
			
			header:'Spaltenname',
			xtype : 'buttoncolumn',
			width : 120,
			glyph : 'xf046@FontAwesome',
			buttonText : 'Actions',
			handler : function(grid, rowIndex, colIndex) {
				var rec = grid.getStore().getAt(rowIndex);
				alert(Ext.String.format('Please select & execute Action for "{0}"', rec.get('company')));
			},
			stopSelection : true, //don't select record on button click
			isDisabledFn : function(v, meta, record) {
				
				return false;//record.get('price') > 70;
			},
			items : [{

				text : 'Sell stock',
				tooltip : 'Sell stock',
				glyph : 'xf046@FontAwesome',
				handler : function(item, data) {
					var rec = data.record;
					alert(format('Cell "{0}"', rec.get('name')));
				}
			}, {

				text : 'Buy stock',
				glyph : 'xf046@FontAwesome',
				tooltip : 'Buy stock',
				handler : function(item, data) {
					var rec = data.record;
					alert(format('Buy "{0}"', rec.get('company')));
				}
			}]
		}];

		this.callParent(arguments);
	}
});
