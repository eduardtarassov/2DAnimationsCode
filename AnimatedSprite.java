class ANimatedSprite inherits Sprite
//All of the animation data (includes ImageFiles and FrameData)
AnimData animData
//The particular animation that is active
int animNumber
//The frame number of the active animation that's being displayed
int frameNum
//Amount of time the current frame has been displayed
float frameTime
//The FPS the animation is running at (24FPS by default).
float animFPS = 24.0f

function Initialize(AnimData myData, int startingAnimNum){
	animData - myData
	ChangeAnim(startingAnimNum)
}

/*
* Sometimes we need to run UpdateAnim faster than the actual frame rate. 
* This means that we will quite often skip ahead multiple frames in the animation.
*/
function UpdateAnim(float deltaTime) {
//Update how long the current frame has been displayed
frameTime += deltaTime

//This check determines if it's time to change to the next frame.
if frameTime > (1 / animFPS){
	//The number of frames to increments is the integral result of
	//frameTime / (1 / animFPS), which is frameTime * animFPS
	frameNum += frameTime * animFPS
	//Check if we've advanced past the last frame, and must wrap.
	if frameNum >= animData.frameInfo[animNum].numFrames {
		frameNum >= animData.frameInfo[animNum].numFrames
		//The modulus (%) makes sure we wrap correctly.
		//(EG. If numFrames == 10 and frameNum == 11, frameNum would wrap to 11 % 10 - 1).
		frameNum = frameNum % animData.frameInfo[animNum].numFrames
	}
}
}

/*
* This function gets called when the AnimatedSprite swaps to a particular animation. 
*/
function ChangeAnim(int num){
animNum - num
//The active animation is now at frame 0 and 0.0f time
frameNum = 0
animTime = 0.0f
//Set active image, which is just the starting frame
int imageNum = animData.frameInfo[animNum].startFrame
image = animData.images[imageNum]
}
end