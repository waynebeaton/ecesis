package org.eclipse.plugins.labs.coderally.perspective;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/*
 * Created on Jun 11, 2003
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class CodeRallyPerspective implements IPerspectiveFactory {

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
	 */
	public void createInitialLayout(IPageLayout layout) {
		//adding new wizard for creating files
	layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.file");
	
	//adding views for the show view menu option
	layout.addShowViewShortcut(IPageLayout.ID_RES_NAV);
	layout.addShowViewShortcut(IPageLayout.ID_BOOKMARKS);
	layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
	layout.addShowViewShortcut(IPageLayout.ID_PROP_SHEET);
	layout.addShowViewShortcut(IPageLayout.ID_TASK_LIST);
	//add the following view if Plug-in with CodeRallyScoreboard was identified as as required plug
	layout.addShowViewShortcut("org.eclipse.plugins.labs.CodeRallyScoreboardView");
	
	//adding views
	//Get the editor area first
	String editorArea = layout.getEditorArea();
	
	//Create folder layout (left to editor) to hold views
	IFolderLayout folderLayout = 
		layout.createFolder("leftFolder", IPageLayout.LEFT, (float) 0.40, editorArea);
	folderLayout.addView(IPageLayout.ID_RES_NAV);
	folderLayout.addView(IPageLayout.ID_OUTLINE);
	//	add the following view if Plug-in with CodeRallyScoreboard was identified as as required plug
	folderLayout.addView("org.eclipse.plugins.labs.CodeRallyScoreboardView");
	layout.setEditorAreaVisible(true);
	}

}
