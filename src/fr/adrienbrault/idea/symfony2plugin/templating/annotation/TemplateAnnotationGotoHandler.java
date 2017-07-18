package fr.adrienbrault.idea.symfony2plugin.templating.annotation;

import de.espend.idea.php.annotation.extension.PhpAnnotationDocTagGotoHandler;
import de.espend.idea.php.annotation.extension.parameter.AnnotationDocTagGotoHandlerParameter;
import fr.adrienbrault.idea.symfony2plugin.Symfony2ProjectComponent;
import fr.adrienbrault.idea.symfony2plugin.TwigHelper;
import fr.adrienbrault.idea.symfony2plugin.templating.util.TwigUtil;
import fr.adrienbrault.idea.symfony2plugin.util.PhpElementsUtil;

/**
 * @author Daniel Espendiller <daniel@espendiller.net>
 */
public class TemplateAnnotationGotoHandler implements PhpAnnotationDocTagGotoHandler {
    @Override
    public void getGotoDeclarationTargets(AnnotationDocTagGotoHandlerParameter parameter) {
        if(!Symfony2ProjectComponent.isEnabled(parameter.getProject())) {
            return;
        }

        if(!PhpElementsUtil.isEqualClassName(parameter.getPhpClass(), TwigHelper.TEMPLATE_ANNOTATION_CLASS)) {
            return;
        }

        parameter.addTargets(TwigUtil.getTemplateAnnotationFilesWithSiblingMethod(parameter.getPhpDocTag()).values());
    }
}
