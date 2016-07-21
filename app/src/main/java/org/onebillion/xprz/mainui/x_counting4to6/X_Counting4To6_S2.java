package org.onebillion.xprz.mainui.x_counting4to6;

import android.graphics.PointF;

import org.onebillion.xprz.controls.OBControl;
import org.onebillion.xprz.controls.OBGroup;
import org.onebillion.xprz.mainui.generic.XPRZ_Generic;
import org.onebillion.xprz.mainui.generic.XPRZ_Generic_AddRemoveObjectsToScene;
import org.onebillion.xprz.utils.OBAnim;
import org.onebillion.xprz.utils.OBAnimationGroup;
import org.onebillion.xprz.utils.OB_Maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

/**
 * Created by pedroloureiro on 21/07/16.
 */
public class X_Counting4To6_S2 extends XPRZ_Generic_AddRemoveObjectsToScene
{
    public X_Counting4To6_S2()
    {
        super(true, false);
    }


    public void demo2a() throws Exception
    {
        setStatus(STATUS_DOING_DEMO);
        loadPointer(POINTER_MIDDLE);
        //
        action_playNextDemoSentence(false); // Look.
        XPRZ_Generic.pointer_moveToObjectByName("container", -15, 0.6f, EnumSet.of(XPRZ_Generic.Anchor.ANCHOR_MIDDLE), true, this);
        waitAudio();
        waitForSecs(0.3);
        //
        action_playNextDemoSentence(false); // You can put a bird on the wire.
        XPRZ_Generic.pointer_moveToObjectByName("obj_1", -20, 1.2f, EnumSet.of(XPRZ_Generic.Anchor.ANCHOR_BOTTOM), true, this);
        waitAudio();
        waitForSecs(0.3);
        //
        action_playNextDemoSentence(false); // Like this.
        XPRZ_Generic.pointer_moveToObjectByName("obj_1", -20, 0.3f, EnumSet.of(XPRZ_Generic.Anchor.ANCHOR_MIDDLE), true, this);
        playSfxAudio("placeObject", false);
        OBControl control = objectDict.get("obj_1");
        control.show();
        waitForSecs(0.3);
        //
        XPRZ_Generic.pointer_moveToObjectByName("obj_1", -20, 0.3f, EnumSet.of(XPRZ_Generic.Anchor.ANCHOR_BOTTOM), true, this);
        waitAudio();
        waitForSecs(0.3);
        //
        thePointer.hide();
        waitForSecs(0.7);
        //
        nextScene();
    }


    public void finalAnimation2b() throws Exception // birds
    {
        List<OBGroup> controls = (List<OBGroup>) (Object) filterControls(getObjectPrefix() + ".*");
        XPRZ_Generic.animate_birds(controls, XPRZ_Generic.AnimationType.ACTIVE, currentEvent(), this);
    }

    public void finalAnimation2c() throws Exception // socks
    {
        List<OBGroup> controls = (List<OBGroup>) (Object) filterControls(getObjectPrefix() + ".*");
        List animations = new ArrayList();
        for (OBGroup control : controls)
        {
            OBAnim anim = OBAnim.sequenceAnim(control, Arrays.asList("frame_1", "frame_2", "frame_3", "frame_2"), 0.075f, true);
            animations.add(anim);
        }
        OBAnimationGroup.runAnims(animations, 0.7f, false, OBAnim.ANIM_LINEAR, this);
    }

    public void finalAnimation2d() throws Exception // vests
    {
        List<OBGroup> controls = (List<OBGroup>) (Object) filterControls(getObjectPrefix() + ".*");
        List animations = new ArrayList();
        for (OBGroup control : controls)
        {
            OBAnim anim = OBAnim.sequenceAnim(control, Arrays.asList("frame_1", "frame_2"), 0.45f, true);
            animations.add(anim);
        }
        OBAnimationGroup.runAnims(animations, 0.7f, false, OBAnim.ANIM_LINEAR, this);
    }

    public void finalAnimation2e() throws Exception // fish
    {
        List<OBGroup> controls = (List<OBGroup>) (Object) filterControls(getObjectPrefix() + ".*");
        for (OBGroup control : controls)
        {
            PointF destination = OB_Maths.AddPoints(new PointF(-bounds().width(), 0), XPRZ_Generic.copyPoint(control.position()));
            OBAnim anim = OBAnim.moveAnim(destination, control);
            OBAnimationGroup.runAnims(Arrays.asList(anim), 0.7f, false, OBAnim.ANIM_LINEAR, this);
            waitForSecs(XPRZ_Generic.randomInt(50, 100) / (float) 1000);
        }
    }


    public void finalAnimation2f() throws Exception // ladybirds
    {
        List<OBGroup> controls = (List<OBGroup>) (Object) filterControls(getObjectPrefix() + ".*");
        XPRZ_Generic.animate_ladybirds(controls, XPRZ_Generic.AnimationType.ACTIVE, currentEvent(), this);
    }


    public void finalAnimation2g() throws Exception // no idea what animation for tomatoes... ¯\_(ツ)_/¯
    {
        List<OBGroup> controls = (List<OBGroup>) (Object) filterControls(getObjectPrefix() + ".*");
        for (OBGroup control : controls)
        {
            OBAnim anim = OBAnim.rotationAnim((float)Math.toRadians(360f), control);
            OBAnimationGroup.runAnims(Arrays.asList(anim), 0.7f, false, OBAnim.ANIM_LINEAR, this);
            waitForSecs(XPRZ_Generic.randomInt(50, 150) / (float) 1000);
        }
    }



    public void finalAnimation2h() throws Exception // candles
    {
        List<OBGroup> controls = (List<OBGroup>) (Object) filterControls(getObjectPrefix() + ".*");
        List animations = new ArrayList();
        for (OBGroup control : controls)
        {
            OBAnim anim = OBAnim.sequenceAnim(control, Arrays.asList("frame1", "frame2"), 0.45f, true);
            animations.add(anim);
        }
        OBAnimationGroup.runAnims(animations, 1.5f, true, OBAnim.ANIM_LINEAR, this);
    }

}