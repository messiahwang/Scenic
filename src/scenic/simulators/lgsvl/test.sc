import scenic.simulators.lgsvl.map
scenic.simulators.lgsvl.map.mapPath = '/Users/francisindaheng/Desktop/Francis/VeHICaL/Code/Z_DO_NOT_DISTRIBUTE/lanelet2.osm'
#scenic.simulators.lgsvl.map.mapPath = '/Users/francisindaheng/Desktop/Francis/VeHICaL/Code/lanelet2_parser/maps/example_map.osm'

from scenic.simulators.lgsvl.road_model import *

""" 
	Test Scenic Road Model:

	Script to test heading and position of road_model.sc 
	for LGSVL Simulator and Lanelet2 files.
	-----
	@author Francis Indaheng
	
	Developed with VeHICaL and all associated 
	groups, projects, and persons.
"""

ego = Car
