import scenic.simulators.lgsvl.lanelet2_parser as parser
from scenic.core.workspaces import Workspace 
from scenic.core.regions import PolygonalRegion
from scenic.core.vectors import VectorField

class LGSVLWorkspace(Workspace):
	def __init__(self, path):
		self.road_map = parser.MapData()
		self.road_map.parse(path)
		# TODO: eventually want to compute sidewalk regions
		self.road_direction = VectorField('Road Direction', self.road_map.heading_at)  # heading_at is a function
		self.drivable_region = PolygonalRegion(polygon=self.road_map.drivable_polygon, orientation=self.road_direction)

	def show(self, plt):
		pass

	@property
    def minimumZoomSize(self):
        return 100