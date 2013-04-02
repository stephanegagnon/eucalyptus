define([
	'dataholder',
  'text!./advanced.html!strip',
  'rivets',
	], function( dataholder, template, rivets ) {
	return Backbone.View.extend({
    title: 'Advanced',

		initialize : function() {

      var self = this;
      var scope = {
        userData: '',
        userFilename: '',
        kernels: '',
        ramdisks: '',
        enableMonitoring: true,
        privateNetwork: false,
        volumes: '',
        snapshots: '',
        blockDeviceMappings: self.model.get('block_device_mappings') ? self.model.get('block_device_mappings') : new Backbone.Collection(),
        enableStorageVolume: false,
        volumeName: '',
        enableMapping: false,
        deviceName: '',
        enableSnapshot: false,
        snapshot: '',
        size: '',
        deleteOnTerm: false,

        setKernel: function() {
          self.model.set('ramdisk_id', e.target.value);
        },

        setDelOnTerm: function() {

        },

        setPrivateNetwork: function() {

        },

        setMonitoring: function(e, item) {
            self.model.set('instance_monitoring', e.target.value);
        },

        setRamDisk: function() {

        },

        setStorageVolume: function() {

        },

        setSnapshot: function() {

        },

        setBlockDeviceMapping: {

        },

      };
      $(this.el).html(template)
      this.rView = rivets.bind(this.$el, scope);
      this.render();
		},

    render: function() {
      this.rView.sync();
    }
});
});