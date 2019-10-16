import scenic.simulators.lgsvl.lanelet2_parser as parser
from scenic.core.workspaces import Workspace 
from scenic.core.regions import PolygonalRegion
from scenic.core.vectors import VectorField

class LGSVLWorkspace(Workspace):
	def __init__(self, path):
		self.road_map = parser.MapData()
		self.road_map.parse(path)
		self.road_map.calculate_drivable_polygon()
		drivable_poly = self.road_map.drivable_polygon
		# TODO: eventually want to compute sidewalk polygon too
		self.road_direction = VectorField('Road Direction', self.road_map.heading_at)
		self.drivable_region = PolygonalRegion(polygon=drivable_poly, orientation=self.road_direction,)

	def show(self, plt):
		pass

	@property
    def minimumZoomSize(self):
        return 100