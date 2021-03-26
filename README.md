# DungLyAssign3
DungLyAssign3 is a project used to pratice about 
Fragments, Drawing activity , animation .

##Installation
Use as apk file to install to use

##Contribution
DUNG LY

##Fragment 1
Allow user to draw and change the brushsize or color they can choose.
Function setbrushsize:
    public void setBrushsize(float nsize)
    {
        drawPaint.setStrokeWidth(nsize);
    }
 Function setColort:
     public void setColor(String newColor)
    {
        invalidate();
        paintColor = Color.parseColor(newColor);
        drawPaint.setColor(paintColor);
    }

##Fragment 2
Ask user for a permission to make a call
Create a animation allow user change the speed of animation 
Function allow user to change the speed of animation by 
    public void animationspeed(int number)
    {
        if (mframeAnimation == null)
        {
            Toast.makeText(getActivity(), R.string.No_ani_run, Toast.LENGTH_SHORT).show();
        } else
        {
            if (!mframeAnimation.isRunning())
            {
                Toast.makeText(getActivity(), R.string.you_have_to_start_ani, Toast.LENGTH_SHORT).show();
            } else
            {
                mframeAnimation.unscheduleSelf(mframeAnimation);
                mframeAnimation = null;
                mframeAnimation = new AnimationDrawable();
                for (int i = 0; i < frame.size(); i++)
                {
                    mframeAnimation.addFrame(frame.get(i), number);
                }
                shark.setBackground(mframeAnimation);
                mframeAnimation.setVisible(true, true);
                mframeAnimation.run();
            }
        }
    }
    
 ##Fragment 3
 Show the textview on top left and right with rotation
 Create a animation the moon run around the eartth.
 Funtion to start animation:
     private void startAni()
    {
        Toast.makeText(getActivity(), R.string.Animation_start, Toast.LENGTH_SHORT).show();

        this.earthImgview.setImageResource(R.drawable.earth);
        this.moonTmgview.setImageResource(R.drawable.moon);


        Animation eAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.earthanimation);
        Animation mAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.moonanimation);

        eAnimation.setRepeatCount(Animation.INFINITE);
        mAnimation.setRepeatMode(Animation.RESTART);
        mAnimation.setRepeatCount(Animation.INFINITE);

        this.moonTmgview.startAnimation(mAnimation);
        this.earthImgview.startAnimation(eAnimation);
    }
AnimationUtils use to load animation on ani source on Drawable

 
 

