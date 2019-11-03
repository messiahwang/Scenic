import math
import time
from scenic.simulators.lgsvl.interface import LGSVLWorkspace
from scenic.simulators.lgsvl.map import mapPath

""" 
	Interface between Scenic and LGSVL Simulator:

	Defines Scenic object construction in relation to a given map file.
	-----
	@author Francis Indaheng
	
	Developed with VeHICaL and all associated 
	groups, projects, and persons.
"""

# # # # # # # # # # # # # # # # # # # # # # # # # #
# MARK: - Intialize workspace and various regions # 
# # # # # # # # # # # # # # # # # # # # # # # # # #

if not mapPath:
	raise RuntimeError('LGSVL map has not been set')
workspace = LGSVLWorkspace(mapPath)

roadDirection = workspace.road_direction
road = workspace.drivable_region

# # # # # # # # # # # # # # # # # #
# MARK: - Types of Scenic objects #
# # # # # # # # # # # # # # # # # #

constructor LGSVLObject:
	lgsvlObject = None
	elevation = None

constructor Car(LGSVLObject):
	regionContainedIn: road
	position: Point on road
	heading: (roadDirection at self.position) + self.roadDeviation
	roadDeviation: 0
	''' TODO: fill out below according to LGSVL specs

	model: Uniform(*carModels)
	width: self.model.width
	height: self.model.height
	webotsType: self.model.name
	viewAngle: 90 deg
	cameraOffset: 0 @ (self.height / 2)		# camera is at the front
	color: CarColor.defaultColor()
	lgsvlName
	lgsvlAgentType

	EgoCar(Car)
	'''

constructor Pedestrian(LGSVLObject):
	regionContainedIn: road
	position: Point on road
	heading: (0, 360) deg
	width: 0.5
	height: 0.5
	''' TODO: fill out below  according to LGSVL specs

	shirtColor: CarColor.uniformColor()
	pantsColor: CarColor.uniformColor()
	shoesColor: CarColor.uniformColor()
	'''
