import scenic.simulators.lgsvl.lanelet2_parser as parser
from scenic.core.workspaces import Workspace 
from scenic.core.regions import PolygonalRegion
from scenic.core.vectors import PolygonalVectorField

""" 
	Inteface between Scenic and LGSVL Simulator:

	Defines a workspace for a given map file.
	-----
	@author Francis Indaheng
	
	Developed with VeHICaL and all associated 
	groups, projects, and persons.
"""

class LGSVLWorkspace(Workspace):
	def __init__(self, path):
		self.road_map = parser.MapData(buffer_=0)
		self.road_map.parse(path)
		# TODO: eventually want to compute sidewalk regions
		self.road_direction = PolygonalVectorField('Road Direction', self.road_map.cells)
		self.drivable_region = PolygonalRegion(polygon=self.road_map.drivable_polygon, orientation=self.road_direction)

	def show(self, plt):
		self.road_map.plot(is_show=True, _type='cell')
		#plt.plot()

	@property
	def minimumZoomSize(self):
		return 100