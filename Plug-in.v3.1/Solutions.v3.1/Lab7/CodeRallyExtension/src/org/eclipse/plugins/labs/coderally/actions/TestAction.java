
package org.eclipse.plugins.labs.coderally.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;


// Referenced classes of package com.ibm.jgfw.plugin:
//            LaunchConfigurationDelegate, Trace

public class TestAction implements IWorkbenchWindowActionDelegate
{
	private IWorkbenchWindow window;

    public TestAction()
    {
    }

    public void dispose()
    {
    }

    public void init(IWorkbenchWindow iworkbenchwindow)
    {
    	window = iworkbenchwindow;
    }

    public void run(IAction action)
    {
    	Display display = Display.getDefault();
		Shell shell = new Shell (display);
    	MessageDialog.openInformation(
    			shell,
    			"Test",
    			"Test Message");
    }


    public void selectionChanged(IAction iaction, ISelection iselection)
    {
    }
}