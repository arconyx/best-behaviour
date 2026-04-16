{
  inputs.nixpkgs.url = "github:NixOS/nixpkgs/nixpkgs-unstable";

  outputs =
    { nixpkgs, ... }:
    let
      lib = nixpkgs.lib;
      # f is a function `system (str) -> packages (attrset) -> attrset`
      forAllSystems =
        f: lib.genAttrs lib.systems.flakeExposed (system: f system nixpkgs.legacyPackages.${system});
    in
    {
      devShells = forAllSystems (
        system: pkgs: {
          default =
            let
              libs = with pkgs; [
                libGL
                glfw3-minecraft
                pipewire
                flite
              ];
              java = pkgs.jdk25;
            in
            pkgs.mkShell {
              nativeBuildInputs = [ java ];

              buildInputs = libs;

              env = {
                LD_LIBRARY_PATH = lib.makeLibraryPath libs;
                JAVA_HOME = java.home;
              };
            };
        }
      );
    };
}
