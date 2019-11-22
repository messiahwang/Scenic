import math
import time
import lgsvl
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
	roadDeviation: 0
	heading: (roadDirection at self.position) + self.roadDeviation
	width: 1  # NOTE: does 1x1 make sense, given a pedestrian is 0.5x0.5?
	height: 1
	lgsvlName: 'Sedan'
	lgsvlAgentType: lgsvl.AgentType.NPC

constructor EgoCar(Car):
	lgsvlName: 'Jaguar2015XE (Apollo 3.0)'
	lgsvlAgentType: lgsvl.AgentType.EGO

constructor Pedestrian(LGSVLObject):
	regionContainedIn: road
	position: Point on road
	heading: (0, 360) deg
	width: 0.5
	height: 0.5
	lgsvlName: 'Bob'
	lgsvlAgentType: lgsvl.AgentType.PEDESTRIAN
