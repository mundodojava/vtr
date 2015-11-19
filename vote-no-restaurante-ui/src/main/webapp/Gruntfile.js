module.exports = function (grunt) {

	// Project configuration.
	grunt.initConfig({
		pkg : grunt.file.readJSON('package.json'),

		uglify : {
			options : {
				banner : '/*! <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> */\n'
			},
			build : {
				src : 'src/<%= pkg.name %>.js',
				dest : 'build/<%= pkg.name %>.min.js'
			}
		},

		karma : {
			unit : {
				configFile : 'karma.conf.js',
				autoWatch: true
			},
			continuous : {
				configFile: "karma.conf.js",
				singleRun : false,
				browsers : ['Chrome']
			},
		}

	});

	// Load the plugin that provides the "uglify" task.
	grunt.loadNpmTasks('grunt-contrib-uglify');
	grunt.loadNpmTasks('grunt-karma');
	grunt.loadNpmTasks('grunt-karma-sonar');

	// Default task(s).
	grunt.registerTask('default', ['uglify']);

	grunt.registerTask('test', ['karma']);

};
