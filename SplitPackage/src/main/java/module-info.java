import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
module SplitPackage {
    requires Common;
    provides IGamePluginService with dk.sdu.mmmi.cbse.playersystem.PlayerPlugin;
}
