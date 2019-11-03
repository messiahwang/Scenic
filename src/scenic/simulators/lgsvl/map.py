# stub to allow changing map path without altering road_model.sc

import os.path

mapPath = None

def setMapPath(module, relpath):
	global mapPath
	base = os.path.dirname(module)
	mapPath = os.path.join(base, relpath)
	